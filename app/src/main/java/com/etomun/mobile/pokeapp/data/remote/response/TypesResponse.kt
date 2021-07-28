package com.etomun.mobile.pokeapp.data.remote.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class TypesResponse {
    @SerializedName("results")
    @Expose
    var results: List<NameUrlResponse>? = null
}