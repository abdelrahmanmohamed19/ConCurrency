package com.example.concurrency.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.concurrency.R
import com.example.concurrency.presentation.ui.FavoritesComponents


@Composable
fun MainHomeView(homeViewModel: HomeViewModel) {


    LazyColumn(Modifier.padding(horizontal = 20.dp)) {
        item {
            CurrencyConverterCard(homeViewModel)
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp), color = Color.LightGray)
            FavoritesComponents(homeViewModel)
            Text(text = stringResource(id = R.string.myPortfolio), fontWeight = W700, modifier = Modifier.padding(bottom = 16.dp))
        }

        items(homeViewModel.state.value.allFavoriteCurrencys) {currency ->
            Row {
                AsyncImage(
                    model = currency.currencyImageLink,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Country Image",
                    error = painterResource(id = R.drawable.placeholder),
                    placeholder = painterResource(id = R.drawable.placeholder),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = currency.currencyCode, fontSize = 16.sp, fontWeight = W400)
                    Text(
                        text = currency.currencyName,
                        fontSize = 12.sp,
                        fontWeight = W400,
                        color = Color.LightGray
                    )
                }

                Text(
                    text = currency.result,
                    fontSize = 18.sp,
                    fontWeight = W700,
                    modifier = Modifier.padding(start = 120.dp)
                )
            }
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), color = Color.LightGray)
        }
    }
}