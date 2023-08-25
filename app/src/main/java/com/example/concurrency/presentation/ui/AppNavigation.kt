package com.example.concurrency.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.concurrency.presentation.compare.CurrencyCompareScreen
import com.example.concurrency.data.Constants
import com.example.concurrency.presentation.compare.CompareViewModel
import com.example.concurrency.presentation.home.HomeViewModel
import com.example.concurrency.presentation.home.MainHomeView


@Composable
fun AppNavigation(route: String, homeViewModel : HomeViewModel , compareViewModel: CompareViewModel ) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = route){

        composable(route = Constants.convertRoute){
           MainHomeView(homeViewModel)
        }
        composable(route = Constants.compareRoute){
            CurrencyCompareScreen(compareViewModel)
        }
    }
}