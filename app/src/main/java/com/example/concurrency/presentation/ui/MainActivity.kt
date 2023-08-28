package com.example.concurrency.presentation.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.concurrency.presentation.compare.CompareViewModel
import com.example.concurrency.presentation.convert.ConvertViewModel
import com.example.concurrency.presentation.favorites.FavoritesViewModel
import com.example.concurrency.ui.theme.ConCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val favoritesViewModel by viewModels<FavoritesViewModel>()
    private val compareViewModel by viewModels<CompareViewModel>()
    private val convertViewModel by viewModels<ConvertViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConCurrencyTheme {
                    AppHomeScreen(favoritesViewModel , convertViewModel , compareViewModel)
                }

            }
        }
    }

