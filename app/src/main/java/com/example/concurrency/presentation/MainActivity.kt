package com.example.concurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.concurrency.presentation.converterCard.CurrencyCompareScreen
import com.example.concurrency.presentation.converterCard.CurrencyConverterCard
import com.example.concurrency.ui.theme.ConCurrencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConCurrencyTheme {
                // A surface container using the 'background' color from the theme
              Box(
                  modifier = Modifier
                      .background(Color.White)
                      .fillMaxSize()
              )
                {
//                   CurrencyConverterCard()
                    CurrencyCompareScreen()
                }
            }
        }
    }
}
