package com.etomun.mobile.pokeapp.domain.usecase

import com.etomun.mobile.pokeapp.domain.base.UseCase
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.domain.result.Species
import io.reactivex.Single
import javax.inject.Inject

class GetSpeciesSumList @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Single<List<Species>>, List<String>> {

    override fun execute(param: List<String>): Single<List<Species>> {
        return pokemonRepository.getSpeciesSums(param)
    }
}