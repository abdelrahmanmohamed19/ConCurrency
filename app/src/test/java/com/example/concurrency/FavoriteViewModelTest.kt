package com.example.concurrency

import com.example.concurrency.data.dummyDataTesting.DummyCurrencyInfoList
import com.example.concurrency.data.dummyDataTesting.DummyCurrencyInfoList.getDummyCurrencyInfoList
import com.example.concurrency.data.dummyDataTesting.DummyFavoritesCurrenciesList.getDummyFavoritesCurrenciesList
import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.local.FavoritesCurrenciesDao
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.data.remote.dto.ExchangeRatesData
import com.example.concurrency.domain.repository.FavoritesCurrenciesRepository
import com.example.concurrency.presentation.favorites.FavoritesState
import com.example.concurrency.presentation.favorites.FavoritesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Test

@ExperimentalCoroutinesApi
class FavoriteViewModelTest {
    @Test
    fun loadingState_isSetCorrectly(){
        val viewModel = getViewModel()
        val state = viewModel.state.value

        // from database
        val myFavoritesList : MutableStateFlow<List<FavoritesCurrencies>> = MutableStateFlow(emptyList())
        myFavoritesList.value = getDummyFavoritesCurrenciesList()

        // from api
        val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())
        currenciesList.value = getDummyCurrencyInfoList()

        assert(
            state == FavoritesState(
                allCurrencies = currenciesList.value,
                isShowDialog = false
            )
                    &&
            viewModel.myFavoriteList == myFavoritesList.value
        )

    }

    private fun getViewModel(): FavoritesViewModel {
        return FavoritesViewModel(FavoritesCurrenciesDaoTest(),FavoritesCurrenciesRepositoryImplTest())
    }





    class FavoritesCurrenciesRepositoryImplTest :FavoritesCurrenciesRepository{
        override suspend fun addCurrency(currency: FavoritesCurrencies) {
            TODO("Not yet implemented")
        }override suspend fun removeCurrency(currency: FavoritesCurrencies) {
            TODO("Not yet implemented")
        }


        // i need this only in test -------------------------------------------------------
        override suspend fun getFavoritesCurrencies(): Flow<List<FavoritesCurrencies>> {
            val myFavoritesList : MutableStateFlow<List<FavoritesCurrencies>> = MutableStateFlow(emptyList())
            myFavoritesList.value = getDummyFavoritesCurrenciesList()
            return myFavoritesList
        }

        override suspend fun getAllCurrencies(): MutableStateFlow<List<CurrencyInfo?>> {
            val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())
            currenciesList.value = getDummyCurrencyInfoList()
            return currenciesList
        }

        // ------------------------------------------------------------------------------------


        override suspend fun getFavoritesExchangeRates(baseCurrency: String): List<ExchangeRatesData?> {
            TODO("Not yet implemented")
        }

    }
    class FavoritesCurrenciesDaoTest : FavoritesCurrenciesDao{
        override suspend fun addCurrency(currency: FavoritesCurrencies) {
            TODO("Not yet implemented")
        }override suspend fun removeCurrency(currencyCode: String) {
            TODO("Not yet implemented")
        }override suspend fun getFavoritesCurrencies(): List<FavoritesCurrencies> {
            TODO("Not yet implemented")
        }

    }
}