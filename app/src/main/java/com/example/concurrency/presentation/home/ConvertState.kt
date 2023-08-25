package com.example.concurrency.presentation.home

import com.example.concurrency.presentation.Currency

data class ConvertState(
    val allCurrencys:List<Currency> = emptyList(),
    val allFavoriteCurrencys:List<Currency> = emptyList(),
    val amount:String = "",
    val baseCurrency: Currency = Currency(),
    val targetCurrency: Currency = Currency(),
    val resultTarget:String = "0",

    // amount error
    val isAmountError:Boolean = false,
    val amountErrorMessage:String = "",

    // user click on drop down list and add to favorites dialog
    val isBaseDropDownExpend:Boolean = false,
    val isTargetDropDownExpend:Boolean = false,
    val isShowDialog:Boolean = false,


    )
