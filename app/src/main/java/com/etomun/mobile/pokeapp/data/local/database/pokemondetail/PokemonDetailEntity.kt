package com.etomun.mobile.pokeapp.data.local.database.pokemondetail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PokemonDetailEntity.TABLE_NAME)
class PokemonDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = C_NAME) var name: String,
    @ColumnInfo(name = C_SP_NAME) var speciesName: String,
    @ColumnInfo(name = C_SPRITE) var sprite: String,
    var spriteShiny: String
) {
    companion object {
        const val TABLE_NAME = "pokemonDetail"
        const val C_NAME = "pokemonName"
        const val C_SP_NAME = "spName"
        const val C_SPRITE = "sprite"
    }
}