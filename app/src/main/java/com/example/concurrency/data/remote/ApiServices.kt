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
import retrofit2.http.Query

interface ApiServices {

//    @GET("currencies-info/currencies")
    @GET("allCurrency.json")
    suspend fun getAllCurrencies () : Response<AllCurrenciesListResponse>

//    @GET("currencies-conversion/currency-conversion")
    @GET("convert.json")
    suspend fun convert (
        @Query ("baseCurrency") baseCurrency : String,
        @Query ("targetCurrency") targetCurrency :String,
        @Query ("amount") amount :String
        ) : Response<ConvertResponse>

    @POST("currencies-compare-rate/currencies-compare")
    suspend fun compare (@Body compareRequestBody : CompareRequestBody) : Response<CompareResponse>

//@GET("exchange-rate/currency-exchange-rate")
   @GET("exchange-rate.json")
    suspend fun exchangeRates (
        @Query ("baseCurrency") baseCurrency : String
    ) : Response <CurrenciesExchangeRatesResponse>

}

