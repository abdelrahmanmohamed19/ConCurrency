package com.example.concurrency.presentation.compare

import com.example.concurrency.data.remote.dto.CurrencyInfo
import kotlinx.coroutines.flow.StateFlow

data class CompareState(
    val allCurrencies: List<CurrencyInfo?> = emptyList(),
    val amount: String = "1",
    val baseCurrency: CurrencyInfo = CurrencyInfo(),
    val firstTargetCurrency: CurrencyInfo = CurrencyInfo(),
    val secondTargetCurrency: CurrencyInfo = CurrencyInfo(),
    val firstResultTarget: String = "1",
    val secondResultTarget: String = "1",
    val isAmountError: Boolean = false,
    val isBaseDropDownExpend: Boolean = false,
    val isFirstTargetDropDownExpend: Boolean = false,
    val isSecondTargetDropDownExpend: Boolean = false,
    val amountErrorMessage: String = "",
    val isNetworkAvailable: Boolean = true,
    val errorMessage : String = ""
)
