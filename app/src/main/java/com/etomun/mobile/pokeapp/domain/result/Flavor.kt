package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flavor(
    var text: String,
    var lang: String
) : Parcelable