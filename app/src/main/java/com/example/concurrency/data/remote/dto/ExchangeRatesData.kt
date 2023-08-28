package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ExchangeRatesData(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("rate")
    val rate: Double? = null
)