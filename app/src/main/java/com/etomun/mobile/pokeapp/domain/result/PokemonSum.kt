package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSum(
    var id: Int,
    var name: String,
    var sprite: String,
    var spriteShiny: String,
    var speciesName: String,
    var types: List<Type>,
) : Parcelable