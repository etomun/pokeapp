package com.etomun.mobile.pokeapp.domain.repository

import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Variety
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface PokemonRepository {
    fun getPokemonList(): Single<List<PokemonSum>>
    fun getPokemonDetail(pokemonName: String, speciesName: String): Observable<PokemonDetail>
    fun getVarietySums(names: List<String>): Single<List<Variety>>

    interface DataSource : PokemonRepository {
        fun persistDetailPokemon(pokemonDetail: PokemonDetail): Completable
        fun persistVariety(variety: Variety): Completable
        fun persistPokemonSum(pokemonSum: PokemonSum): Completable
    }
}