package com.example.concurrency.presentation.compare

import android.net.ConnectivityManager
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrency.data.remote.dto.CompareRequestBody
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.CompareRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CompareViewModel @Inject constructor(private val repo : CompareRepository , private val connectivityManager: ConnectivityManager): ViewModel() {

    private var _state by mutableStateOf( CompareState() )

    init {
        getAllCurrencies()
    }

    val state:State<CompareState>
        get() =  derivedStateOf{_state}


    fun onAmountChange(amount:String){
        _state = if (amount.toDoubleOrNull() != null || amount.isEmpty()){
            _state.copy(
                amount = amount,
                isAmountError = false,
                amountErrorMessage = ""
            )
        } else{
            _state.copy(
                isAmountError = true,
                amountErrorMessage = "Please enter a valid amount*"
            )
        }
    }

    fun onBaseDropDownListClick(){
        _state =  _state.copy(
           isBaseDropDownExpend = true
        )
    }
    fun onFirstDropDownListClick(){
        _state =  _state.copy(
            isFirstTargetDropDownExpend = true
        )
    }
    fun onSecondDropDownListClick(){
        _state =  _state.copy(
            isSecondTargetDropDownExpend = true
        )
    }
    fun onDropDownListDismiss(){
        _state =  _state.copy(
            isBaseDropDownExpend = false ,
            isFirstTargetDropDownExpend = false,
            isSecondTargetDropDownExpend = false
        )
    }
    fun onBaseCurrencyChange(currency: CurrencyInfo){
        _state =  _state.copy(
            baseCurrency = currency
        )
    }
    fun onFirstTargetCurrencyChange(currency: CurrencyInfo){
        _state =  _state.copy(
            firstTargetCurrency = currency
        )
    }

    fun onSecondTargetCurrencyChange(currency: CurrencyInfo){
        _state =  _state.copy(
            secondTargetCurrency = currency
        )
    }

    fun onCompareClick() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                checkNetworkAvailability() // Check network availability first
                if (_state.isNetworkAvailable) {
                    val result = repo.compare(compareRequestBody = CompareRequestBody(
                        _state.baseCurrency.currencyCode!!,
                        _state.firstTargetCurrency.currencyCode!!,
                        _state.secondTargetCurrency.currencyCode!!,
                        _state.amount
                    ))
                     _state = _state.copy(
                        firstResultTarget = result.firstTargetResult.toString(),
                        secondResultTarget = result.secondTargetResult.toString()
                    )
                } else {
                    // Network is not available, update the state to show an error message
                    _state = _state.copy(
                        firstResultTarget = "",
                        secondResultTarget = ""
                    )
                }
            } catch (e: Exception) {
                // Handle the network error, update state to show error message
                _state = _state.copy(
                    firstResultTarget = "",
                    secondResultTarget = ""
                )
            }
        }
    }

    private fun getAllCurrencies() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repo.getAllCurrencies().value
            _state = _state.copy( allCurrencies = list , baseCurrency = list[0]!! , firstTargetCurrency = list[1]!! , secondTargetCurrency = list[2] !!)
        }
    }

    private fun checkNetworkAvailability() : Boolean {
            val networkInfo = connectivityManager.activeNetworkInfo
           _state =_state.copy(isNetworkAvailable =  networkInfo != null && networkInfo.isConnected)
          return _state.isNetworkAvailable
    }
}