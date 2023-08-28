package com.example.concurrency.data.remote.dto

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class CompareRequestBody(
    @SerializedName ("baseCode")
    val baseCode : String,
    @SerializedName ("firstTargetCode")
    val firstTargetCode : String,
    @SerializedName ("secondTargetCode")
    val secondTargetCode :String,
    @SerializedName ("amount")
    val amount :String
)