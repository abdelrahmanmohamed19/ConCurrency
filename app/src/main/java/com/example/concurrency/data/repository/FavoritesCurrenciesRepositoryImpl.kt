package com.example.concurrency.data.repository

import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.local.FavoritesCurrenciesDao
import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.data.remote.dto.ExchangeRatesData
import com.example.concurrency.domain.repository.FavoritesCurrenciesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FavoritesCurrenciesRepositoryImpl @Inject constructor(private val dao : FavoritesCurrenciesDao , private val api : ApiServices) : FavoritesCurrenciesRepository {

    override suspend fun addCurrency(currency: FavoritesCurrencies) {
        dao.addCurrency(currency)
    }

    override suspend fun removeCurrency(currency: FavoritesCurrencies) {
        dao.removeCurrency(currency.currencyCode)
    }


    override suspend fun getFavoritesCurrencies() : Flow<List<FavoritesCurrencies>> {

        val myFavoritesList : MutableStateFlow<List<FavoritesCurrencies>> = MutableStateFlow(emptyList())
        myFavoritesList.value = dao.getFavoritesCurrencies()
        return myFavoritesList
    }

    override suspend fun getAllCurrencies(): MutableStateFlow<List<CurrencyInfo?>> {
        val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())

        val response = api.getAllCurrencies()

        if (response.isSuccessful) {
            val responseBody = response.body()?.currencyInfoList
            responseBody?.let {  currenciesList.value = it }
        }
        return currenciesList
    }

    override suspend fun getFavoritesExchangeRates(baseCurrency : String) : List<ExchangeRatesData?>{
        var responseData = emptyList<ExchangeRatesData?>()
        val response = api.exchangeRates(baseCurrency)
        if (response.isSuccessful) {
            val responseBody = response.body()?.data
            responseData = responseBody !!
        }
        return responseData
    }
}