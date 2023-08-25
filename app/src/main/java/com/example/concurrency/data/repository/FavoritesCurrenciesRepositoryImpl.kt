package com.example.concurrency.data.repository

import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.local.FavoritesCurrenciesDao
import com.example.concurrency.domain.repository.FavoritesCurrenciesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FavoritesCurrenciesRepositoryImpl @Inject constructor(private val dao : FavoritesCurrenciesDao): FavoritesCurrenciesRepository {

    override suspend fun addCurrency(currency: FavoritesCurrencies) {
        dao.addCurrency(currency)
    }

    override suspend fun removeCurrency(currency: FavoritesCurrencies) {
        dao.removeCurrency(currency)
    }

    override suspend fun getFavoritesCurrencies(): MutableStateFlow<List<FavoritesCurrencies>> {
        val favoritesCurrenciesList = MutableStateFlow(emptyList<FavoritesCurrencies>())
        favoritesCurrenciesList.value = dao.getFavoritesCurrencies()
        return favoritesCurrenciesList
    }
}