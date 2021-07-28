package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weakness(
    var type: Type,
    var multiplier: Double
) : Parcelable