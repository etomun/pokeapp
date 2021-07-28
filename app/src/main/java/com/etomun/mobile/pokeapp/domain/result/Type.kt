package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type(
    var name: String,
    var tagRes: Int,
    var typeRes: Int
) : Parcelable