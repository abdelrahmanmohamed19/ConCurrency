package com.example.concurrency.data.dummyDataTesting

import com.example.concurrency.data.local.FavoritesCurrencies
import com.example.concurrency.data.remote.dto.CurrencyInfo

object DummyFavoritesCurrenciesList {
    fun getDummyFavoritesCurrenciesList() = arrayListOf(
        FavoritesCurrencies(currencyCode = "EGP",flag = "https://wise.com/public-resources/assets/flags/rectangle/egp.png",currencyName = "Egyptian Pound" ),
        FavoritesCurrencies(currencyCode = "JPY",flag = "https://wise.com/public-resources/assets/flags/rectangle/jpy.png",currencyName = "Japan Yen" ),
        FavoritesCurrencies(currencyCode = "QAR",flag = "https://wise.com/public-resources/assets/flags/rectangle/qar.png",currencyName = "QATARI Riyal" ),
    )
}