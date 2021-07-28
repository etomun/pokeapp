package com.etomun.mobile.pokeapp.domain.repository

import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Species
import io.reactivex.Observable
import io.reactivex.Single

interface PokemonRepository {
    fun getPokemonList(): Single<List<PokemonSum>>
    fun getPokemonDetail(pokemonName: String, speciesName: String): Observable<PokemonDetail>
    fun getSpeciesSums(names: List<String>): Single<List<Species>>

    interface DataSource : PokemonRepository
}