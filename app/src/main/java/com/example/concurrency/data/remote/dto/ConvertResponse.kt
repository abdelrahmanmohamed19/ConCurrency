package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ConvertResponse(
    @SerializedName("data")
    val conversionData: ConversionData? = ConversionData(),
    @SerializedName("status")
    val status: String? = ""
)