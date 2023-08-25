package com.example.concurrency.domain.repository

import com.example.concurrency.data.local.FavoritesCurrencies
import kotlinx.coroutines.flow.Flow

interface FavoritesCurrenciesRepository {

    suspend fun addCurrency (currency : FavoritesCurrencies)

    suspend fun removeCurrency (currency: FavoritesCurrencies)

    suspend fun getFavoritesCurrencies() : Flow<List<FavoritesCurrencies>>

}