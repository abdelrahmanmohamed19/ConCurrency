package com.example.concurrency.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.concurrency.R

@Preview(showBackground = true)
@Composable
fun FavoritesListScreen() {
    var isSelected by remember { mutableStateOf(false) }
    val list = listOf("USD", "EUR", "GBP", "JPY")

    Column(Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
            ) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
            }
        }

        Card(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Text(text = stringResource(id = R.string.addtofavorites), fontSize = 18.sp ,fontWeight = FontWeight.W700, color = Color.Black , modifier = Modifier.padding(start = 8.dp ,top = 12.dp , bottom = 12.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp)
            ) {
                items(list) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.usa_flag),
                            contentDescription = "",
                            modifier = Modifier.padding(end = 16.dp)
                        )
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(text = it, fontSize = 16.sp, fontWeight = FontWeight.W400)
                            Text(
                                text = "Currency",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400,
                                color = Color.LightGray
                            )
                        }
                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                            IconButton(onClick = { isSelected = !isSelected }) {
                                if (isSelected) {
                                    Icon(Icons.Filled.CheckCircle, contentDescription = "")
                                } else {
                                    Icon(
                                        painterResource(id = R.drawable.not_selected_icon),
                                        contentDescription = ""
                                    )
                                }
                            }
                        }

                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp), color = Color.LightGray
                    )
                }
            }
        }

    }
}