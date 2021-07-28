package com.etomun.mobile.pokeapp.domain.usecase

import com.etomun.mobile.pokeapp.domain.base.UseCase
import com.etomun.mobile.pokeapp.domain.param.PokemonDetailParam
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import io.reactivex.Observable
import javax.inject.Inject

class GetPokemonDetail @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Observable<PokemonDetail>, PokemonDetailParam> {

    override fun execute(param: PokemonDetailParam): Observable<PokemonDetail> {
        return pokemonRepository.getPokemonDetail(param.pokemonName, param.speciesName)
    }
}