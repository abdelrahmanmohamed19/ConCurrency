package com.example.concurrency.data.local

import androidx.room.Entity

@Entity(tableName = "FavoritesCurrencies")
data class FavoritesCurrencies(
    val currencyCode : String,
    val currencyName : String,
    val flag : String,
    val amount : String
)
