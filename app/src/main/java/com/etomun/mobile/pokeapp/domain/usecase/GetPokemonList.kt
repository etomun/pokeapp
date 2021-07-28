package com.etomun.mobile.pokeapp.domain.usecase

import com.etomun.mobile.pokeapp.domain.base.UseCase
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import io.reactivex.Single
import javax.inject.Inject

class GetPokemonList @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Single<List<PokemonSum>>, Void?> {

    override fun execute(param: Void?): Single<List<PokemonSum>> {
        return pokemonRepository.getPokemonList()
    }
}