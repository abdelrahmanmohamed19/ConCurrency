package com.example.concurrency.di

import android.content.Context
import androidx.room.Room
import com.example.concurrency.data.local.FavoritesCurrenciesDao
import com.example.concurrency.data.local.FavoritesCurrenciesDatabase
import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.data.repository.CompareRepositoryImpl
import com.example.concurrency.data.repository.FavoritesCurrenciesRepositoryImpl
import com.example.concurrency.data.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase (@ApplicationContext context: Context) =
        Room.databaseBuilder(context,FavoritesCurrenciesDatabase::class.java,"FavoritesCurrenciesDatabase").build()

    @Provides
    @Singleton
    fun providesDatabaseDao (database: FavoritesCurrenciesDatabase) = database.getFavoritesCurrenciesDao()

    @Provides
    @Singleton
    fun providesRetrofit (): Retrofit = Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesApiServices () : ApiServices = providesRetrofit().create(ApiServices::class.java)

    @Provides
    @Singleton
    fun provideHomeRepository () = HomeRepositoryImpl(providesApiServices())

    @Provides
    @Singleton
    fun provideCompareRepository () = CompareRepositoryImpl(providesApiServices())

    @Provides
    @Singleton
    fun provideFavoritesCurrenciesRepository (@ApplicationContext context: Context) = FavoritesCurrenciesRepositoryImpl(providesDatabaseDao(providesDatabase(context))
    )

}