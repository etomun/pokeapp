package com.etomun.mobile.pokeapp.domain.usecase

import com.etomun.mobile.pokeapp.domain.base.UseCase
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import com.etomun.mobile.pokeapp.domain.result.Variety
import io.reactivex.Single
import javax.inject.Inject

class GetVarietySumList @Inject internal constructor(private val pokemonRepository: PokemonRepository) :
    UseCase<Single<List<Variety>>, List<String>> {

    override fun execute(param: List<String>): Single<List<Variety>> {
        return pokemonRepository.getVarietySums(param)
    }
}