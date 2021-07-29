package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Evolution(
    var chainId: Int,
    var fromName: String,
    var fromSprite: String,
    var toName: String,
    var toSprite: String,
    var trigger: String,
    var triggerSpecs: String
) : Parcelable