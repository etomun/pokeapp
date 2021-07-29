package com.etomun.mobile.pokeapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.etomun.mobile.pokeapp.BuildConfig
import com.etomun.mobile.pokeapp.data.local.database.ability.AbilityDao
import com.etomun.mobile.pokeapp.data.local.database.ability.AbilityEntity
import com.etomun.mobile.pokeapp.data.local.database.evolution.EvolutionDao
import com.etomun.mobile.pokeapp.data.local.database.evolution.EvolutionEntity
import com.etomun.mobile.pokeapp.data.local.database.pokemon.PokemonDao
import com.etomun.mobile.pokeapp.data.local.database.pokemon.PokemonEntity
import com.etomun.mobile.pokeapp.data.local.database.pokemondetail.PokemonDetailDao
import com.etomun.mobile.pokeapp.data.local.database.pokemondetail.PokemonDetailEntity
import com.etomun.mobile.pokeapp.data.local.database.pokemonsum.PokeSumDao
import com.etomun.mobile.pokeapp.data.local.database.pokemonsum.PokeSumEntity
import com.etomun.mobile.pokeapp.data.local.database.stat.StatDao
import com.etomun.mobile.pokeapp.data.local.database.stat.StatEntity
import com.etomun.mobile.pokeapp.data.local.database.type.TypeDao
import com.etomun.mobile.pokeapp.data.local.database.type.TypeEntity
import com.etomun.mobile.pokeapp.data.local.database.variety.VarietyDao
import com.etomun.mobile.pokeapp.data.local.database.variety.VarietyEntity
import com.etomun.mobile.pokeapp.data.local.database.weakness.WeaknessDao
import com.etomun.mobile.pokeapp.data.local.database.weakness.WeaknessEntity

@Database(
    version = AppDatabase.DB_VERSION,
    entities = [
        AbilityEntity::class,
        EvolutionEntity::class,
        PokemonEntity::class,
        PokemonDetailEntity::class,
        PokeSumEntity::class,
        StatEntity::class,
        TypeEntity::class,
        VarietyEntity::class,
        WeaknessEntity::class,
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun abilityDao(): AbilityDao
    abstract fun evolutionDao(): EvolutionDao
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokeDetailDao(): PokemonDetailDao
    abstract fun pokeSumDao(): PokeSumDao
    abstract fun statDao(): StatDao
    abstract fun typeDao(): TypeDao
    abstract fun varietyDao(): VarietyDao
    abstract fun weaknessDao(): WeaknessDao

    companion object {
        const val DB_NAME =
            "PEnBkH7e32qZn0MvQKV3vNZaFFizJiQu" + BuildConfig.FLAVOR + BuildConfig.BUILD_TYPE
        const val DB_VERSION = 1
    }

}