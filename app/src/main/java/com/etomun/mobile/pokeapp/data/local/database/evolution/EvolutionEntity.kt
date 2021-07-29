package com.etomun.mobile.pokeapp.data.local.database.evolution

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = EvolutionEntity.TABLE_NAME)
class EvolutionEntity(
    @ColumnInfo(name = C_CHAIN) var chainId: Int,
    var fromName: String,
    var fromSprite: String,
    var toName: String,
    var toSprite: String,
    var trigger: String,
    var triggerSpecs: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    companion object {
        const val TABLE_NAME = "evolution"
        const val C_CHAIN = "chainId"
    }
}