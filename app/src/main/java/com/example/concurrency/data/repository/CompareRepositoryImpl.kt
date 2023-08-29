package com.example.concurrency.data.repository

import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.data.remote.dto.CompareRequestBody
import com.example.concurrency.data.remote.dto.ConversionRates
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.CompareRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CompareRepositoryImpl @Inject constructor(private val api : ApiServices) : CompareRepository {

    override suspend fun getAllCurrencies(): MutableStateFlow<List<CurrencyInfo?>> {
        val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())

        val response = api.getAllCurrencies()

        if (response.isSuccessful) {
            val responseBody = response.body()?.currencyInfoList
            responseBody?.let {  currenciesList.value = it }
        }
        return currenciesList
    }

    override suspend fun compare(compareRequestBody: CompareRequestBody): ConversionRates {

        lateinit var conversionRates : ConversionRates

        val response = api.compare(compareRequestBody)

        if (response.isSuccessful) {
            val responseBody = response.body()?.comparisonData?.conversionRates
            conversionRates = responseBody !!
        }
        return conversionRates
    }
}