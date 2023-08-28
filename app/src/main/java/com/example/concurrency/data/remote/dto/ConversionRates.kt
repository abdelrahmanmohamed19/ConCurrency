package com.example.concurrency.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ConversionRates (
    @SerializedName("firstTargetRate")
    val firstTargetResult: Double? = null ,
    @SerializedName("secondTargetRate")
    val secondTargetResult: Double? = null
)