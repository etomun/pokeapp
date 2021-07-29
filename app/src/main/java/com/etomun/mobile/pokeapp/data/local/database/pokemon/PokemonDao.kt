package com.etomun.mobile.pokeapp.data.local.database.pokemon

import androidx.room.Dao
import androidx.room.Query
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import com.etomun.mobile.pokeapp.data.local.database.pokemondetail.PokemonDetailEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PokemonDao : BaseDao<PokemonDetailEntity> {
    @Query("select * from ${PokemonEntity.TABLE_NAME}")
    fun getAll(): Single<List<PokemonDetailEntity>>

    @Query("delete from ${PokemonEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}