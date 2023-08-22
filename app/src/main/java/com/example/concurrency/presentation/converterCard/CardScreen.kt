package com.example.concurrency.presentation.converterCard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.concurrency.R
import com.example.concurrency.ui.theme.CardBackground
import com.example.concurrency.ui.theme.CardTextColor

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrencyConverterCard() {
    var show by remember { mutableStateOf(false) }
  Column (
      modifier = Modifier.padding(25.dp),
      horizontalAlignment = Alignment.CenterHorizontally
  ){
      CurrencyConverterTitle()
      Card(
          modifier = Modifier
              .fillMaxWidth(),
          colors = CardDefaults.cardColors(
              containerColor = CardBackground,
          ),
          elevation = CardDefaults.cardElevation(
              defaultElevation = 10.dp
          ),
          shape = RoundedCornerShape(16.dp),
      ) {
          Column(
              modifier = Modifier
                  .padding(16.dp)
          ) {
              MyTextTitle(text = stringResource(R.string.amount),0)
              UserEditText(20)
              MyTextTitle(text = stringResource(R.string.from),20)
              DropDownList(20)
              MyTextTitle(text = stringResource(R.string.to),20)
              DropDownList(20)
              AnimatedVisibility(visible = show, modifier = Modifier.padding(top =20.dp)) {
                  Text(
                      text = "1.00 US Dollar =\n" +
                              "0.92203078 Euros\n" +
                              "1 EUR = 1.08456 USD",
                      color = CardTextColor
                  )
              }
              ButtonClickOn(
                  buttonText = stringResource(R.string.convert),
                  paddingTopValue = 40) {
                  show = show.not()
              }



          }
      }
  }
}
