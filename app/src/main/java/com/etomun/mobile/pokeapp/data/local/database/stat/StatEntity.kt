package com.etomun.mobile.pokeapp.data.local.database.stat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = StatEntity.TABLE_NAME)
class StatEntity(
    @PrimaryKey
    @ColumnInfo(name = C_NAME) var name: String,
    var base: Int,
    var effort: Int
) {
    companion object {
        const val TABLE_NAME = "stat"
        const val C_NAME = "statName"
    }
}