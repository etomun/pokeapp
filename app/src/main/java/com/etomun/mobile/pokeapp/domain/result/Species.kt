package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Species(
    var name: String,
    var sprite: String
) : Parcelable