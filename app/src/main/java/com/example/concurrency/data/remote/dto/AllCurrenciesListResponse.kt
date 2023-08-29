package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AllCurrenciesListResponse(
    @SerializedName("data")
    val currencyInfoList: List<CurrencyInfo?>? = null,
    @SerializedName("status")
    val status: String? = null,
    )