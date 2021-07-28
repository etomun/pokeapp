package com.etomun.mobile.pokeapp.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FlavorTextEntry {
    @SerializedName("flavor_text")
    @Expose
    var flavorText: String? = null

    @SerializedName("language")
    @Expose
    var language: NameUrlResponse? = null
}