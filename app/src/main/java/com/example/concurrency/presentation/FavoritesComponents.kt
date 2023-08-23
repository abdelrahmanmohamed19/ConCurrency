package com.example.concurrency.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.concurrency.R

@Preview(showBackground = true)
@Composable
fun FavoritesComponents() {

    Column(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp)
        .background(Color.White)) {

        Row {
            Text(
                text = "live exchange rates",
                fontSize = 16.sp,
                fontWeight = W600,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 12.dp)
            )

            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(start = 32.dp)
                    .wrapContentWidth(),
                border = BorderStroke(1.dp, color = Color.Black),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(Color.White)) {
                Image(painter = painterResource(id = R.drawable.add_icon), contentDescription = "")
                Text(
                    text = "Add to Favorites",
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 4.dp),
                    fontWeight = W500
                )
            }
        }
        val list = listOf("USD", "EUR", "GBP", "JPY")

        Text(text = "My Portfolio", fontWeight = W700, modifier = Modifier.padding(bottom = 12.dp))


        LazyColumn {
            items(list) {
                Row(modifier = Modifier.padding(bottom = 16.dp)) {
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
                        modifier = Modifier.padding(start = 140.dp)
                    )
                }
            }
        }


    }
}