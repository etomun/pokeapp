package com.etomun.mobile.pokeapp.data.local.source

import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository.DataSource
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Species
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PokemonLocalSource @Inject internal constructor() : DataSource {
    override fun getPokemonList(): Single<List<PokemonSum>> {
        return Single.error(UnsupportedOperationException())
    }

    override fun getPokemonDetail(pokemonName: String, speciesName: String)
            : Observable<PokemonDetail> {
        return Observable.error(UnsupportedOperationException())
    }

    override fun getSpeciesSums(names: List<String>): Single<List<Species>> {
        return Single.error(UnsupportedOperationException())
    }

}