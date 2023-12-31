package com.example.concurrency.presentation.convert

import com.example.concurrency.data.remote.dto.CurrencyInfo

data class ConvertState(
    val allCurrencies: List<CurrencyInfo?> = emptyList(),
    val amount: String = "1",
    val baseCurrency: CurrencyInfo = CurrencyInfo(),
    val targetCurrency: CurrencyInfo = CurrencyInfo(),
    val resultTarget: String = "1",

    // amount error
    val isAmountError: Boolean = false,
    val amountErrorMessage: String = "",

    // user click on drop down list and add to favorites dialog
    val isBaseDropDownExpend: Boolean = false,
    val isTargetDropDownExpend: Boolean = false,

    val isNetworkAvailable: Boolean = true,
    val errorMessage : String = ""
)
