package com.etomun.mobile.pokeapp.data.repository

import com.etomun.mobile.pokeapp.common.di.qualifier.data.LocalData
import com.etomun.mobile.pokeapp.common.di.qualifier.data.RemoteData
import com.etomun.mobile.pokeapp.data.base.BaseRepository
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository.DataSource
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Species
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepoFactory @Inject constructor(
    @LocalData localData: DataSource,
    @RemoteData remoteData: DataSource
) :
    BaseRepository<DataSource>(localData, remoteData), PokemonRepository {
    override fun getPokemonList(): Single<List<PokemonSum>> {
        return if (remoteDataSourceEmpty()) {
            Single.error(IllegalArgumentException())
        } else {
            remoteData!!.getPokemonList()
        }
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
    : Observable<PokemonDetail> {
        return if (remoteDataSourceEmpty()) {
            Observable.error(IllegalArgumentException())
        } else {
            remoteData!!.getPokemonDetail(pokemonName, speciesName)
        }
    }

    override fun getSpeciesSums(names: List<String>): Single<List<Species>> {
        return if (remoteDataSourceEmpty()) {
            Single.error(IllegalArgumentException())
        } else {
            remoteData!!.getSpeciesSums(names)
        }
    }

}