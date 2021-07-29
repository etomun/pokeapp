package com.etomun.mobile.pokeapp.data.local.source

import com.etomun.mobile.pokeapp.data.local.database.AppDatabase
import com.etomun.mobile.pokeapp.data.local.mapper.VarietyEntityMapper
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository.DataSource
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Variety
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PokemonLocalSource @Inject internal constructor(
    private val db: AppDatabase,
    private val varietyMapper: VarietyEntityMapper
) : DataSource {
    override fun persistDetailPokemon(pokemonDetail: PokemonDetail): Completable {
        return Completable.never()
        // TODO
//        db.pokeDetailDao().insertReplace(detailMapper.fromData(pokemonDetail))
    }

    override fun persistVariety(variety: Variety): Completable {
        return db.varietyDao().insertReplace(varietyMapper.fromData(variety))
    }

    override fun persistPokemonSum(pokemonSum: PokemonSum): Completable {
        TODO("Not yet implemented")
    }

    override fun getPokemonList(): Single<List<PokemonSum>> {
        return Single.error(UnsupportedOperationException())
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return Observable.error(UnsupportedOperationException())
    }

    override fun getVarietySums(names: List<String>): Single<List<Variety>> {
        return Observable.just(names)
            .flatMapIterable { arr -> arr }
            .flatMap { db.varietyDao().getAll(it).toObservable() }
            .flatMapIterable { sums -> sums }
            .map { varietyMapper.toData(it) }
            .toList()
    }

}