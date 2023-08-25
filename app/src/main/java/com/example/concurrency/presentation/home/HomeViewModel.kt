package com.example.concurrency.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.concurrency.presentation.Currency
import com.example.concurrency.presentation.allCurrency
import com.example.concurrency.presentation.compare.CompareState

class HomeViewModel : ViewModel() {

    private var _state by mutableStateOf(
        ConvertState()
    )

    init {
        // cal api to get all currencys

        // get all favorite currencys from database and call api
        // to calculate them with baseCurrency

        _state =  _state.copy(
            allCurrencys = allCurrency,
            allFavoriteCurrencys = allCurrency,
            baseCurrency = allCurrency[0],
            targetCurrency = allCurrency[1],
        )
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
    fun onBaseCurrencyChange(currency: Currency){
        _state =  _state.copy(
            baseCurrency = currency
        )
    }
    fun onTargetCurrencyChange(currency: Currency){
        _state =  _state.copy(
            targetCurrency = currency
        )
    }

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


    fun onSelectFavoriteCurrency(currency: Currency){
        // here will change favorite currency in database
    }


    fun onConvertClick(){
        // here use api to calculate amount base/target/amount
    }



}