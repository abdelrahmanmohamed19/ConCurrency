package com.example.concurrency.domain.repository

import com.example.concurrency.data.remote.dto.CurrencyInfo
import kotlinx.coroutines.flow.MutableStateFlow


interface ConvertRepository {

    suspend fun getAllCurrencies () : MutableStateFlow<List<CurrencyInfo?>>

    suspend fun convert (baseCurrency : String, targetCurrency :String, amount :String) : String?
}