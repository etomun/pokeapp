package com.etomun.mobile.pokeapp.data.remote.mapper

import com.etomun.mobile.pokeapp.common.util.helper.DataConverter
import com.etomun.mobile.pokeapp.data.base.DataMapper
import com.etomun.mobile.pokeapp.data.remote.response.SpeciesSumResponse
import com.etomun.mobile.pokeapp.domain.result.Species
import javax.inject.Inject

class SpeciesSumResponseMapper @Inject internal constructor(private val converter: DataConverter) :
    DataMapper<SpeciesSumResponse?, Species> {
    override fun fromData(data: Species): SpeciesSumResponse? {
        return null
    }

    override fun toData(source: SpeciesSumResponse?): Species {
        if (source == null) {
            throw UnsupportedOperationException()
        }
        val name = source.name.orEmpty()
        val default = source.sprites?.frontDefault.orEmpty()
        val official = source.sprites?.other?.officialArtwork?.frontDefault.orEmpty()
        val sprite = if (official.isEmpty()) default else official
        return Species(name, sprite)
    }
}