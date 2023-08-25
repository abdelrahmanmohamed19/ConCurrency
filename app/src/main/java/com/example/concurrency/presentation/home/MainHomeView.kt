package com.example.concurrency.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.concurrency.R
import com.example.concurrency.presentation.ui.FavoritesComponents
import com.example.concurrency.ui.theme.CardComponentBackground


@Composable
fun MainHomeView(homeViewModel: HomeViewModel) {

    LazyColumn(Modifier.padding(horizontal = 20.dp)) {
        item {
            CurrencyConverterCard(homeViewModel)
            Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp), color = Color.LightGray)
            FavoritesComponents(homeViewModel)
            Text(text = "My Portfolio", fontWeight = W700, modifier = Modifier.padding(bottom = 16.dp))
        }
        val list = listOf("USD", "EUR", "GBP", "JPY")

        items(list) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.usa_flag),
                    contentDescription = "",
                    modifier = Modifier.padding(end = 16.dp)
                )


                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = it, fontSize = 16.sp, fontWeight = W400)
                    Text(
                        text = "Currency",
                        fontSize = 12.sp,
                        fontWeight = W400,
                        color = Color.LightGray
                    )
                }

                Text(
                    text = "$29,850.15",
                    fontSize = 18.sp,
                    fontWeight = W700,
                    modifier = Modifier.padding(start = 120.dp)
                )
            }
            Divider(modifier =  Modifier.fillMaxWidth().padding(vertical = 8.dp), color = Color.LightGray)
        }
    }
}