package com.etomun.mobile.pokeapp.data.local.database.type

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TypeEntity.TABLE_NAME)
class TypeEntity(
    @PrimaryKey
    @ColumnInfo(name = C_NAME) var name: String,
    @ColumnInfo(name = C_TAG_R) var tagRes: Int,
    @ColumnInfo(name = C_TYPE_R) var typeRes: Int
) {
    companion object {
        const val TABLE_NAME = "type"
        const val C_NAME = "typeName"
        const val C_TAG_R = "tagRes"
        const val C_TYPE_R = "typeRes"
    }
}