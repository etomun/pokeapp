package com.etomun.mobile.pokeapp.data.remote.response

data class PokemonDetailResponsesComposer(
    val pokemon: PokemonDetailResponse,
    val species: SpeciesDetailResponse,
    val abilities: List<AbilityDetailResponse>,
    val typeDamages: List<TypeDamageResponse>,
    val evolution: EvolutionChainResponse,
    val types: TypesResponse
)
