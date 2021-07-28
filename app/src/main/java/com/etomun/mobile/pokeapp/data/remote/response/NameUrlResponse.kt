package com.etomun.mobile.pokeapp.data.remote.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class NameUrlResponse {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}