package com.etomun.mobile.pokeapp.data.local.mapper

import com.etomun.mobile.pokeapp.data.base.DataMapper
import com.etomun.mobile.pokeapp.data.local.database.weakness.WeaknessEntity
import com.etomun.mobile.pokeapp.domain.result.Type
import com.etomun.mobile.pokeapp.domain.result.Weakness
import javax.inject.Inject

class WeaknessEntityMapper @Inject internal constructor() : DataMapper<WeaknessEntity, Weakness> {
    override fun fromData(data: Weakness) = WeaknessEntity(
        data.pokemonId,
        data.type.name,
        data.type.tagRes,
        data.type.typeRes,
        data.multiplier
    )

    override fun toData(source: WeaknessEntity): Weakness {
        val type = Type(source.typeName, source.tagRes, source.typeRes)
        return Weakness(source.pokemonId, type, source.multiplier)
    }
}