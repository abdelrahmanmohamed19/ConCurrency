package com.example.concurrency.presentation.compare

import com.example.concurrency.presentation.Currency

data class CompareState(
    val allCurrencys:List<Currency> = emptyList(),
    val amount:String = "",
    val baseCurrency:Currency = Currency(),
    val firstTargetCurrency:Currency = Currency(),
    val secondTargetCurrency:Currency = Currency(),
    val firstResultTarget:String = "0",
    val secondResultTarget:String = "0",

    //
    val isAmountError:Boolean = false,
    val isBaseDropDownExpend:Boolean = false,
    val isFirstTargetDropDownExpend:Boolean = false,
    val isSecondTargetDropDownExpend:Boolean = false,
    val amountErrorMessage:String = "",


)
