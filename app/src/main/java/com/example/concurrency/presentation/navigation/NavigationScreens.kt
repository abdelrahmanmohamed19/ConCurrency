package com.example.concurrency.presentation.navigation

import androidx.compose.ui.res.stringResource
import com.example.concurrency.R

sealed class NavigationScreens(val route:String,val title:String){
    object ConvertScreen:NavigationScreens(
        route = Constants.ConvertRoute,
        title ="Convert"
    )    object CompareScreen:NavigationScreens(
        route = Constants.CompareRoute,
        title ="Compare"
    )
}
