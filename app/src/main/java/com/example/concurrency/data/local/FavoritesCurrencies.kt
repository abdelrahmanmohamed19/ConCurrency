package com.example.concurrency.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoritesCurrencies")
data class FavoritesCurrencies(
    @PrimaryKey ()
    val currencyCode : String,
    val currencyName : String,
    val flag : String,
    var amount : String = "0"
)
