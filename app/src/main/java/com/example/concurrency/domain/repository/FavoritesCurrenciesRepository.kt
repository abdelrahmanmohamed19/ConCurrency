package com.example.concurrency.domain.repository

import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.data.remote.dto.ExchangeRatesData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface FavoritesCurrenciesRepository {

    suspend fun addCurrency (currency : FavoritesCurrencies)

    suspend fun removeCurrency (currency: FavoritesCurrencies)

    suspend fun getFavoritesCurrencies() : Flow<List<FavoritesCurrencies>>

    suspend fun getAllCurrencies () : MutableStateFlow<List<CurrencyInfo?>>

    suspend fun getFavoritesExchangeRates (baseCurrency : String) : List<ExchangeRatesData?>

}