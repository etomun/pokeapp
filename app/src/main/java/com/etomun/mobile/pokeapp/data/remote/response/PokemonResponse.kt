package com.etomun.mobile.pokeapp.data.remote.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PokemonResponse {
    @SerializedName("count")
    @Expose
    var count = 0

    @SerializedName("next")
    @Expose
    var next: String? = null

    @SerializedName("previous")
    @Expose
    var previous: String? = null

    @SerializedName("results")
    @Expose
    var results: List<NameUrlResponse>? = null
}