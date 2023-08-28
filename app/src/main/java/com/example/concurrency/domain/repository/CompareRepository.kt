package com.example.concurrency.domain.repository

import com.example.concurrency.data.remote.dto.CompareRequestBody
import com.example.concurrency.data.remote.dto.ConversionRates
import com.example.concurrency.data.remote.dto.CurrencyInfo
import kotlinx.coroutines.flow.MutableStateFlow

interface CompareRepository {

    suspend fun getAllCurrencies () : MutableStateFlow<List<CurrencyInfo?>>

    suspend fun compare (compareRequestBody: CompareRequestBody) : ConversionRates

}