package com.etomun.mobile.pokeapp.data.repository

import com.etomun.mobile.pokeapp.common.di.qualifier.data.LocalData
import com.etomun.mobile.pokeapp.common.di.qualifier.data.RemoteData
import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import com.etomun.mobile.pokeapp.data.base.BaseRepository
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository.DataSource
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Variety
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class PokemonRepoFactory @Inject constructor(
    @LocalData localData: DataSource,
    @RemoteData remoteData: DataSource,
    private val scheduler: RxScheduler
) :
    BaseRepository<DataSource>(localData, remoteData), PokemonRepository {
    override fun getPokemonList(): Single<List<PokemonSum>> {
        return if (remoteDataSourceEmpty()) {
            Single.error(IllegalArgumentException())
        } else {
            // TODO get from DB first, build own pagination mapping
            remoteData!!.getPokemonList()
        }
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return if (remoteDataSourceEmpty()) {
            Observable.error(IllegalArgumentException())
        } else {
            // TODO get from DB first
//            return Observable.mergeDelayError(
//                localData.getPokemonDetail(pokemonName, speciesName)
//                    .onErrorResumeNext(Observable.error(::Throwable)),
//                remoteData!!.getPokemonDetail(pokemonName, speciesName).doOnNext {
//                        localData.persistDetailPokemon(it).onErrorComplete().subscribe()
//                },
//            )
            remoteData!!.getPokemonDetail(pokemonName, speciesName)
        }
    }

    override fun getVarietySums(names: List<String>): Single<List<Variety>> {
        return if (remoteDataSourceEmpty()) {
            Single.error(IllegalArgumentException())
        } else {
            remoteData!!.getVarietySums(names)
        }
    }

}