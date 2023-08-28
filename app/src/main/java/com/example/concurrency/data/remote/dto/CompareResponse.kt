package com.example.concurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CompareResponse(
    @SerializedName("data")
    val comparisonData : ComparisonData? = ComparisonData(),
    @SerializedName("status")
    val status: String? = ""
)