package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CurrenciesExchangeRatesResponse(
    @SerializedName("data")
    val `data`: List<ExchangeRatesData?>? = null,
    @SerializedName("status")
    val status: String? = null
)