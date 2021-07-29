package com.etomun.mobile.pokeapp.data.local.database.variety

import androidx.room.Dao
import androidx.room.Query
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface VarietyDao : BaseDao<VarietyEntity> {
    @Query("select * from ${VarietyEntity.TABLE_NAME} where ${VarietyEntity.C_NAME}=:name")
    fun getAll(name: String): Single<List<VarietyEntity>>

    @Query("delete from ${VarietyEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}