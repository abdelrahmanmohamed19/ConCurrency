package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ConversionData(
    @SerializedName("baseCode")
    val baseCode: String? = null,
    @SerializedName("conversionRate")
    val conversionRate: String? = null,
    @SerializedName("conversionResult")
    val conversionResult: String? = null,
    @SerializedName("targetCode")
    val targetCode: String? = null
)