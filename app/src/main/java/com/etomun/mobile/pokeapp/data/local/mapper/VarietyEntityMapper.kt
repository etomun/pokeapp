package com.etomun.mobile.pokeapp.data.local.mapper

import com.etomun.mobile.pokeapp.data.base.DataMapper
import com.etomun.mobile.pokeapp.data.local.database.variety.VarietyEntity
import com.etomun.mobile.pokeapp.domain.result.Variety
import javax.inject.Inject

class VarietyEntityMapper @Inject internal constructor() : DataMapper<VarietyEntity, Variety> {
    override fun fromData(data: Variety) = VarietyEntity(data.name, data.sprite)
    override fun toData(source: VarietyEntity) = Variety(source.name, source.sprite)
}