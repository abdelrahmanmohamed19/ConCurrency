package com.example.concurrency.presentation.compare

import com.example.concurrency.data.remote.dto.CurrencyInfo

data class CompareState(
    val allCurrencies:List<CurrencyInfo?> = emptyList(),
    val amount:String = "0",
    val baseCurrency: CurrencyInfo = CurrencyInfo(),
    val firstTargetCurrency: CurrencyInfo = CurrencyInfo(),
    val secondTargetCurrency: CurrencyInfo = CurrencyInfo(),
    val firstResultTarget:String = "0",
    val secondResultTarget:String = "0",

    val isAmountError:Boolean = false,
    val isBaseDropDownExpend:Boolean = false,
    val isFirstTargetDropDownExpend:Boolean = false,
    val isSecondTargetDropDownExpend:Boolean = false,
    val amountErrorMessage:String = "",
    )
