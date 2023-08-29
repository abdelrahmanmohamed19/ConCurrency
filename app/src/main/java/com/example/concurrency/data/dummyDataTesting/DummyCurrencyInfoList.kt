package com.example.concurrency.data.dummyDataTesting


import com.example.concurrency.data.remote.dto.CurrencyInfo

object DummyCurrencyInfoList {
    fun getDummyCurrencyInfoList() = arrayListOf(
        CurrencyInfo(currencyCode = "EGP",flagUrl = "https://wise.com/public-resources/assets/flags/rectangle/egp.png",name = "Egyptian Pound",isFavourite = false),
        CurrencyInfo(currencyCode = "USD",flagUrl = "https://wise.com/public-resources/assets/flags/rectangle/usd.png",name = "US Dollar",isFavourite = true),
        CurrencyInfo(currencyCode = "JPY",flagUrl = "https://wise.com/public-resources/assets/flags/rectangle/jpy.png",name = "Japan Yen",isFavourite = true),
        CurrencyInfo(currencyCode = "KWD",flagUrl = "https://wise.com/public-resources/assets/flags/rectangle/kwd.png",name = "Kuwait Dinar",isFavourite = false),
        CurrencyInfo(currencyCode = "OMR",flagUrl = "https://wise.com/public-resources/assets/flags/rectangle/omr.png",name = "Oman Riyal",isFavourite = true),
        CurrencyInfo(currencyCode = "QAR",flagUrl = "https://wise.com/public-resources/assets/flags/rectangle/qar.png",name = "QATARI Riyal",isFavourite = true),
    )
}
