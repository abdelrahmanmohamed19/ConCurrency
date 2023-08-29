package com.example.concurrency.data.remote

import com.example.concurrency.data.remote.dto.AllCurrenciesListResponse
import com.example.concurrency.data.remote.dto.CompareRequestBody
import com.example.concurrency.data.remote.dto.CompareResponse
import com.example.concurrency.data.remote.dto.ConvertResponse
import com.example.concurrency.data.remote.dto.CurrenciesExchangeRatesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiServices {

    @GET("currencies-info/currencies")
    suspend fun getAllCurrencies(): Response<AllCurrenciesListResponse>

    @GET("currencies-conversion/currency-conversion/{baseCurrency}/{targetCurrency}/{amount}")
    suspend fun convert(
        @Path("baseCurrency") baseCurrency: String,
        @Path("targetCurrency") targetCurrency: String,
        @Path("amount") amount: String
    ): Response<ConvertResponse>

    @POST("currencies-compare-rate/currencies-compare")
    suspend fun compare(@Body compareRequestBody: CompareRequestBody): Response<CompareResponse>

    @GET("exchange-rate/currency-exchangeRate/{baseCurrency}")
    suspend fun exchangeRates(
        @Path("baseCurrency") baseCurrency: String
    ): Response<CurrenciesExchangeRatesResponse>
}

