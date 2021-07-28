package com.etomun.mobile.pokeapp.data.remote.source

import com.etomun.mobile.pokeapp.data.remote.api.PokemonApi
import com.etomun.mobile.pokeapp.data.remote.mapper.PokemonDetailResponseMapper
import com.etomun.mobile.pokeapp.data.remote.mapper.PokemonSumResponseMapper
import com.etomun.mobile.pokeapp.data.remote.mapper.SpeciesSumResponseMapper
import com.etomun.mobile.pokeapp.data.remote.response.*
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository.DataSource
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Species
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class PokemonRemoteSource @Inject internal constructor(
    private val pokemonApi: PokemonApi,
    private val sumMapper: PokemonSumResponseMapper,
    private val detailMapper: PokemonDetailResponseMapper,
    private val spSumMapper: SpeciesSumResponseMapper,
) : DataSource {
    override fun getPokemonList(): Single<List<PokemonSum>> {
        return pokemonApi.getPokemonList(limit = 20, offset = 0)
            .filter { !it.results.isNullOrEmpty() }
            .map { it.results }
            .flatMapIterable { pokes -> pokes }
            .flatMap { pokemonApi.getPokemonDetail(it.name.orEmpty()) }
            .map { sumMapper.toData(it) }
            .toList()
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return Observable.zip(
            pokemonApi.getPokemonDetail(pokemonName),
            pokemonApi.getSpeciesDetail(speciesName)
        ) { pokemon, species -> Pair(pokemon, species) }
            .flatMap { pair ->
                Observable.zip(
                    Observable.just(pair.first),
                    Observable.just(pair.second),
                    getAbilities(pair.first),
                    getTypeDamages(pair.first),
                    getEvolutions(pair.second),
                    pokemonApi.getTypes()
                ) { p, s, a, d, e, t ->
                    detailMapper.toData(PokemonDetailResponsesComposer(p, s, a, d, e, t))
                }
            }
    }

    override fun getSpeciesSums(names: List<String>): Single<List<Species>> {
        return Observable.fromIterable(names)
            .flatMap { pokemonApi.getSpeciesSum(it) }
            .map { spSumMapper.toData(it) }
            .toList()

    }

    private fun getAbilities(pokemonResponse: PokemonDetailResponse): Observable<List<AbilityDetailResponse>> {
        return Observable.fromArray(pokemonResponse.abilities)
            .flatMapIterable { abilities -> abilities }
            .flatMap { pokemonApi.getAbilityDetail(it.ability?.name.orEmpty()) }
            .toList()
            .toObservable()
            .doOnNext { Timber.e("Abilities: ${it.size}") }
    }

    private fun getTypeDamages(pokemonResponse: PokemonDetailResponse): Observable<List<TypeDamageResponse>> {
        return Observable.fromArray(pokemonResponse.types)
            .flatMapIterable { types -> types }
            .flatMap { pokemonApi.getTypeDamages(it.type?.name.orEmpty()) }
            .toList()
            .toObservable()
    }

    private fun getEvolutions(speciesResponse: SpeciesDetailResponse): Observable<EvolutionChainResponse> {
        val evolutionUrl = speciesResponse.evolutionChain!!.url
        val evolutionIdString =
            evolutionUrl?.substringAfterLast("/evolution-chain/")?.filter { it.isDigit() }
        val evoId: Int = evolutionIdString?.toInt() ?: 0
        return pokemonApi.getEvolutionChain(evoId)
    }

}