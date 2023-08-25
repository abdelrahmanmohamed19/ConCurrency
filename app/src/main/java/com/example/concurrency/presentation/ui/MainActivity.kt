package com.example.concurrency.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.concurrency.presentation.compare.CompareViewModel
import com.example.concurrency.presentation.home.AppHomeScreen
import com.example.concurrency.presentation.home.HomeViewModel
import com.example.concurrency.ui.theme.ConCurrencyTheme

class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
    private val compareViewModel by viewModels<CompareViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConCurrencyTheme {
                AppHomeScreen(homeViewModel = homeViewModel, compareViewModel = compareViewModel )
            }
        }
    }
}
