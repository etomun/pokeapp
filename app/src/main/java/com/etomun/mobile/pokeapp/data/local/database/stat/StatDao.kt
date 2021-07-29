package com.etomun.mobile.pokeapp.data.local.database.stat

import androidx.room.Dao
import androidx.room.Query
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface StatDao : BaseDao<StatEntity> {
    @Query("select * from ${StatEntity.TABLE_NAME}")
    fun getAll(): Single<List<StatEntity>>

    @Query("delete from ${StatEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}