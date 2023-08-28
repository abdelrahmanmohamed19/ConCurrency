package com.example.concurrency.presentation.convert

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.ConvertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ConvertViewModel @Inject constructor(private val repo : ConvertRepository)  : ViewModel() {

    private var _state by mutableStateOf(
        ConvertState()
    )

    init {
        getAllCurrencies()
    }

    val state: State<ConvertState>
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

    fun onTargetDropDownListClick(){
        _state =  _state.copy(
            isTargetDropDownExpend = true
        )
    }

    fun onDropDownListDismiss(){
        _state =  _state.copy(
            isBaseDropDownExpend = false ,
            isTargetDropDownExpend = false,
        )
    }

    fun onBaseCurrencyChange(currency: CurrencyInfo){
        _state =  _state.copy(
            baseCurrency = currency
        )
    }

    fun onTargetCurrencyChange(currency: CurrencyInfo){
        _state =  _state.copy(
            targetCurrency = currency
        )
    }

    fun onConvertClick()  {
        viewModelScope.launch(Dispatchers.IO) {
           val result = repo.convert(_state.baseCurrency.currencyCode !!,_state.targetCurrency.currencyCode !!,_state.amount) !!
            _state = _state.copy( resultTarget = result )
        }
    }

    private fun getAllCurrencies() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repo.getAllCurrencies().value
            _state = _state.copy( allCurrencies = list , baseCurrency = list[0]!! , targetCurrency = list[0]!! )
        }
    }



}