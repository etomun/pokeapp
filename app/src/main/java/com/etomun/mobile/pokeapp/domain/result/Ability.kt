package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ability(
    var id: Int,
    var name: String,
    var effect: String,
    var shortEffect: String,
    var flavorText: String,
    var slot: Int,
    var isHidden: Boolean
) : Parcelable