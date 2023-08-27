package com.example.concurrency.data.repository

import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.ConvertRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ConvertRepositoryImpl @Inject constructor(private val api : ApiServices): ConvertRepository {

    override suspend fun getAllCurrencies(): MutableStateFlow<List<CurrencyInfo?>> {
        val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())

        val response = api.getAllCurrencies()

        if (response.isSuccessful) {
            val responseBody = response.body()?.currencyInfoList
            responseBody?.let {  currenciesList.value = it }
        }
        return currenciesList
    }

    override suspend fun convert(baseCurrency: String, targetCurrency: String, amount: String): String {
        val response = api.convert(baseCurrency,targetCurrency, amount)
        var conversionResult  = ""

        if (response.isSuccessful) {
            val responseBody = response.body()?.conversionData?.conversionResult
            responseBody?.let { conversionResult = it }
        }
        return conversionResult

    }

}