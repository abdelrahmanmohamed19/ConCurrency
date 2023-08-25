package com.example.concurrency.presentation

data class Currency(
    val currencyName:String = "",
    val currencyCode:String = "",
    val currencyImageLink:String= "",
    val isFavorite:Boolean = false,
    val result:String = "0"
)





val allCurrency = listOf(
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
    Currency(currencyName = "Egyptian Pound", currencyCode = "EGP", currencyImageLink = "https://www.exchangerate-api.com/img/docs/JP.gif"),
)