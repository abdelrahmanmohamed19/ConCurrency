package com.example.concurrency.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.concurrency.presentation.converterCard.CurrencyCompareScreen
import com.example.concurrency.presentation.converterCard.CurrencyConverterCard


@Composable
fun AppNavigation(route: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = route,){

        composable(route = Constants.ConvertRoute){
            CurrencyConverterCard()
        }
        composable(route = Constants.CompareRoute){
            CurrencyCompareScreen()
        }
    }
}