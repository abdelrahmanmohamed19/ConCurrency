package com.example.concurrency.presentation.favorites

import com.example.concurrency.data.remote.dto.CurrencyInfo


data class FavoritesState(
    val allCurrencies:List<CurrencyInfo?> = emptyList(),
    val isShowDialog:Boolean = false
)
