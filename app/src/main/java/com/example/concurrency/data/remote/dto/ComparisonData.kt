package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ComparisonData(
    @SerializedName("base_code")
    val baseCode: String? = null,
    @SerializedName("conversion_rates")
    val conversionRates: ConversionRates? = null
)
