package com.example.concurrency.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
interface FavoritesCurrenciesDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCurrency (currency : FavoritesCurrencies)

    @Query("DELETE FROM FavoritesCurrencies WHERE currencyCode=:currencyCode ")
    suspend fun removeCurrency (currencyCode : String)

    @Query("SELECT * FROM FavoritesCurrencies")
    suspend fun getFavoritesCurrencies() : List<FavoritesCurrencies>

}