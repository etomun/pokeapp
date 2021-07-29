package com.etomun.mobile.pokeapp.data.local.database.type

import androidx.room.Dao
import androidx.room.Query
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface TypeDao : BaseDao<TypeEntity> {
    @Query("select * from ${TypeEntity.TABLE_NAME}")
    fun getAll(): Single<List<TypeEntity>>

    @Query("delete from ${TypeEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}