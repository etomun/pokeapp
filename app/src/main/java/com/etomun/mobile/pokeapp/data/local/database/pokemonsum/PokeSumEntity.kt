package com.etomun.mobile.pokeapp.data.local.database.pokemonsum

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.etomun.mobile.pokeapp.data.local.database.pokemon.PokemonEntity
import com.etomun.mobile.pokeapp.data.local.database.type.TypeEntity

@Entity(
    tableName = PokeSumEntity.TABLE_NAME,
    primaryKeys = [PokemonEntity.C_NAME, TypeEntity.C_NAME],
)
class PokeSumEntity(
    @ColumnInfo(name = PokemonEntity.C_NAME)
    val pokemonName: String,
    @ColumnInfo(name = TypeEntity.C_NAME)
    val typeName: String
) {

    companion object {
        const val TABLE_NAME = "pokemonSum"
    }
}