package com.example.concurrency.presentation.converterCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrencyConverterCard() {
    var show by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
  Column (
      modifier = Modifier
          .padding(horizontal = 25.dp)
          .verticalScroll(scrollState)
      ,

  ){
      Row {
          MyTextTitle(text = stringResource(R.string.amount),0,Modifier.weight(0.40f))
          Spacer(modifier = Modifier.width(10.dp))
          MyTextTitle(text = stringResource(R.string.from),0,Modifier.weight(0.60f))
      }
      Row(){
          UserEditText(20, modifier = Modifier.weight(0.40f))
          Spacer(modifier = Modifier.width(10.dp))
          DropDownList(20, modifier = Modifier.weight(0.60f))
      }

      Row {
          MyTextTitle(text = stringResource(R.string.to),20,Modifier.weight(0.60f))
          Spacer(modifier = Modifier.width(10.dp))
          MyTextTitle(text = stringResource(R.string.amount),20,Modifier.weight(0.40f))
      }
      Row{
          DropDownList(20,Modifier.weight(0.60f))
          Spacer(modifier = Modifier.width(10.dp))
          ResultView("1",20,Modifier.weight(0.40f))
      }

      ButtonClickOn(
          buttonText = stringResource(R.string.convert),
          paddingTopValue = 40) {
          show = show.not()
      }
  }
}
