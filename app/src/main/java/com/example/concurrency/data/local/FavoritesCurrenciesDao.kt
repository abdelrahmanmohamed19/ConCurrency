package com.example.concurrency.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesCurrenciesDao {

    @Insert
    suspend fun addCurrency (currency : FavoritesCurrencies)

    @Delete
    suspend fun removeCurrency (currency: FavoritesCurrencies)

    @Query("SELECT * FROM FavoritesCurrencies")
    suspend fun getFavoritesCurrencies() : List<FavoritesCurrencies>

}