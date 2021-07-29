package com.etomun.mobile.pokeapp.data.local.database.pokemonsum

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import com.etomun.mobile.pokeapp.data.local.database.pokemon.PokemonEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PokeSumDao : BaseDao<PokeSumEntity> {
    @Query("select * from ${PokeSumEntity.TABLE_NAME}")
    fun getPokemonSum(): Single<List<PokeSumEntity>>

//    @Transaction
//    @Query("select * from ${PokemonEntity.TABLE_NAME} where ${PokemonEntity.C_NAME} = :pokeName")
//    fun getPokemonWithTypes(pokeName: String): Single<PokemonTypes>

    @Query("delete from ${PokeSumEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}