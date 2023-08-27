package com.example.concurrency.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.concurrency.presentation.compare.CurrencyCompareScreen
import com.example.concurrency.data.Constants
import com.example.concurrency.presentation.compare.CompareViewModel
import com.example.concurrency.presentation.convert.ConvertViewModel
import com.example.concurrency.presentation.favorites.FavoritesViewModel


@Composable
fun AppNavigation(route: String, favoritesViewModel : FavoritesViewModel, convertViewModel: ConvertViewModel ,compareViewModel: CompareViewModel ) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = route){

        composable(route = Constants.convertRoute){
           MainHomeView(convertViewModel, favoritesViewModel)
        }
        composable(route = Constants.compareRoute){
            CurrencyCompareScreen(compareViewModel)
        }
    }
}