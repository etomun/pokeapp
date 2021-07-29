package com.etomun.mobile.pokeapp.data.local.database.ability

import androidx.room.Dao
import androidx.room.Query
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface AbilityDao : BaseDao<AbilityEntity> {
    @Query("select * from ${AbilityEntity.TABLE_NAME}")
    fun getAll(): Single<List<AbilityEntity>>

    @Query("delete from ${AbilityEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}