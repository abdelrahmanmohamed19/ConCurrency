package com.example.concurrency.presentation.favorites

import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.remote.dto.CurrencyInfo
import kotlinx.coroutines.flow.MutableStateFlow


data class FavoritesState(
    val allCurrencies:List<CurrencyInfo?> = emptyList(),
    val allFavoriteCurrencies:MutableStateFlow<List<FavoritesCurrencies>> = MutableStateFlow(emptyList()),
    val isShowDialog:Boolean = false
)
