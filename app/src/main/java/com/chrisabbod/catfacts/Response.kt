package com.chrisabbod.catfacts

import com.google.gson.annotations.SerializedName

data class BaseJSONResponse(
    @SerializedName("current_page")
    var currentPage: Int,
    @SerializedName("data")
    var data: Set<Data>
)

data class Data(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)
