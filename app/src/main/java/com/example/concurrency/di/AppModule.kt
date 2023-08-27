package com.example.concurrency.di

import android.content.Context
import androidx.room.Room
import com.example.concurrency.data.local.FavoritesCurrenciesDatabase
import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.data.repository.CompareRepositoryImpl
import com.example.concurrency.data.repository.FavoritesCurrenciesRepositoryImpl
import com.example.concurrency.data.repository.ConvertRepositoryImpl
import com.example.concurrency.domain.repository.CompareRepository
import com.example.concurrency.domain.repository.ConvertRepository
import com.example.concurrency.domain.repository.FavoritesCurrenciesRepository
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
    fun providesRetrofit (): Retrofit = Retrofit.Builder().baseUrl("https://allcurrency-5081e-default-rtdb.firebaseio.com/").addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesApiServices () : ApiServices = providesRetrofit().create(ApiServices::class.java)

    @Provides
    @Singleton
    fun provideConvertRepository () : ConvertRepository = ConvertRepositoryImpl(providesApiServices())

    @Provides
    @Singleton
    fun provideCompareRepository ()  : CompareRepository = CompareRepositoryImpl(providesApiServices())

    @Provides
    @Singleton
    fun provideFavoritesCurrenciesRepository (@ApplicationContext context: Context) : FavoritesCurrenciesRepository = FavoritesCurrenciesRepositoryImpl(providesDatabaseDao(providesDatabase(context)),
    providesApiServices())

}