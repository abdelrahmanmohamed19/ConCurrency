package com.example.concurrency.presentation.compare

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.concurrency.presentation.Currency
import com.example.concurrency.presentation.allCurrency

class CompareViewModel : ViewModel() {

    private var _state by mutableStateOf(
        CompareState()
    )

    init {
        _state =  _state.copy(
            allCurrencys = allCurrency,
            baseCurrency = allCurrency[0], // make init first item in get list of currency
            firstTargetCurrency = allCurrency[1],
           secondTargetCurrency =  allCurrency[2],
        )
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
    fun onBaseCurrencyChange(currency:Currency){
        _state =  _state.copy(
            baseCurrency = currency
        )
    }
    fun onFirstTargetCurrencyChange(currency:Currency){
        _state =  _state.copy(
            firstTargetCurrency = currency
        )
    }

    fun onSecondTargetCurrencyChange(currency:Currency){
        _state =  _state.copy(
            secondTargetCurrency = currency
        )
    }

    fun onCompareClick(){
        // here use api to calculate amount base/target1/target2/amount

    }
}