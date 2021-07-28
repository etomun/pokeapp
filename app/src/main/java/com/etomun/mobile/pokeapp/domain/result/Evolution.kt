package com.etomun.mobile.pokeapp.domain.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Evolution(
    val from: Species,
    val to: Species,
    val trigger: String,
    val upsideDown: Boolean,
    val gender: Int? = null,
    val heldItem: String? = null,
    val item: String? = null,
    val knownMove: String? = null,
    val knownMoveType: String? = null,
    val location: String? = null,
    val minAffection: Int? = null,
    val minBeauty: Int? = null,
    val minHappiness: Int? = null,
    val minLevel: Int? = null,
    val needsOverWorldRain: Boolean = false,
    val partySpecies: String? = null,
    val partyType: String? = null,
    val relativePhysicalStats: Int? = null,
    val timeOfDay: String? = null,
    val tradeSpecies: String? = null
) : Parcelable