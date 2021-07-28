package com.etomun.mobile.pokeapp.data.remote.mapper

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.RoundingMode
import java.text.DecimalFormat

class PokemonDetailResponseMapperTest {

    @Test
    fun roundOffDecimal() {
        val female = roundOffDecimal((1 * 100 / 8.0))
        val male = roundOffDecimal((7 * 100 / 8.0))
        assertEquals(12.5, female, 0.0)
        assertEquals(87.5, male, 0.0)
    }

    private fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }
}