package com.etomun.mobile.pokeapp.data.local.database.pokemonsum

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.etomun.mobile.pokeapp.data.local.database.pokemon.PokemonEntity
import com.etomun.mobile.pokeapp.data.local.database.pokemondetail.PokemonDetailEntity
import com.etomun.mobile.pokeapp.data.local.database.type.TypeEntity

data class PokemonTypes(
    @Embedded
    val pokemon: PokemonDetailEntity,

    @Relation(
        parentColumn = PokemonEntity.C_NAME,
        entityColumn = TypeEntity.C_NAME,
        associateBy = Junction(PokeSumEntity::class)
    )
    val types: List<TypeEntity>
)