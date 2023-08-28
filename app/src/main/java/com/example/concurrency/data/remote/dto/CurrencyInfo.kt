package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CurrencyInfo(
    @SerializedName("currencyCode")
    val currencyCode: String? = null,
    @SerializedName("flagUrl")
    val flagUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    var isFavourite : Boolean = false
)