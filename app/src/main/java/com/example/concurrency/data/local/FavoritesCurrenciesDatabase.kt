package com.example.concurrency.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database (entities = [FavoritesCurrencies::class] , version = 1 ,exportSchema = false)
abstract class FavoritesCurrenciesDatabase : RoomDatabase() {

    abstract fun getFavoritesCurrenciesDao() : FavoritesCurrenciesDao

}