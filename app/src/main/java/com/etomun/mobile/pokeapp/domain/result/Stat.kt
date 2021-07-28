package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stat(
    var name: String,
    var base: Int,
    var effort: Int
) : Parcelable