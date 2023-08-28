package com.example.concurrency.presentation.favorites

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.local.FavoritesCurrenciesDao
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.FavoritesCurrenciesRepository
import com.example.concurrency.presentation.convert.ConvertState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.Currency
import javax.inject.Inject


@HiltViewModel
class FavoritesViewModel @Inject constructor(private val dao : FavoritesCurrenciesDao, private val repo : FavoritesCurrenciesRepository) : ViewModel() {

    private var _state by mutableStateOf( FavoritesState() )
    var myFavoriteList = mutableStateOf(emptyList<FavoritesCurrencies>())


    init {
        viewModelScope.launch {
            getMyFavorites()
        }
        getAllCurrencies()
    }

    val state: State<FavoritesState>
        get() =  derivedStateOf{_state}


    fun onAddToFavoriteClick(){
        _state =  _state.copy(
            isShowDialog = true
        )
    }
    fun onCloseMyFavorite(){
        _state =  _state.copy(
            isShowDialog = false
         )
    }

    fun onSelectFavoriteCurrency(currency: CurrencyInfo ){
        viewModelScope.launch(Dispatchers.IO) {
            if (currency.isFavourite) {
                dao.removeCurrency(currency.currencyCode.toString())
            }
            else  {
                val newCurrency = FavoritesCurrencies(currencyCode = currency.currencyCode !! , currencyName = currency.name !! , flag = currency.flagUrl !!)
                dao.addCurrency(newCurrency)
            }
            currency.isFavourite = currency.isFavourite.not()
            viewModelScope.launch{ getMyFavorites() }
    }
    }

    private suspend fun getMyFavorites () {
        repo.getFavoritesCurrencies().collect{
            myFavoriteList.value = it
        }
    }


    private fun getAllCurrencies() {
        viewModelScope.launch(Dispatchers.IO) {
            val currencyApi = repo.getAllCurrencies().value
            for (currencyInfo in currencyApi) {
                val foundInDatabase = myFavoriteList.value.any{it.currencyCode == currencyInfo?.currencyCode}
                if (foundInDatabase) {
                    currencyInfo?.isFavourite = true
                }
            }
            _state = _state.copy( allCurrencies = currencyApi)
        }
    }

    fun getExchangeRates(baseCurrency: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val currencyApi = repo.getFavoritesExchangeRates(baseCurrency = baseCurrency)
            val updatedList = myFavoriteList.value.map { favoriteCurrency ->
                val matchingApiCurrency = currencyApi.find { it?.code == favoriteCurrency.currencyCode }
                if (matchingApiCurrency != null) {
                    favoriteCurrency.copy(amount = matchingApiCurrency.rate.toString())
                } else {
                    favoriteCurrency
                }
            }
            myFavoriteList.value = updatedList
        }
    }
}