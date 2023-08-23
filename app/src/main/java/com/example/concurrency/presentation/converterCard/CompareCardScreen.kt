package com.example.concurrency.presentation.converterCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
fun CurrencyCompareScreen() {
    var show by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier.padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Column {
            Row {
                MyTextTitle(text = stringResource(R.string.amount),0, Modifier.weight(0.50f))
                Spacer(modifier = Modifier.weight(0.10f))
                MyTextTitle(text = stringResource(R.string.from),0, Modifier.weight(0.50f))

            }
            Row{
                UserEditText(20, modifier = Modifier.weight(0.45f))
                Spacer(modifier = Modifier.weight(0.10f))
                DropDownList(20, modifier = Modifier.weight(0.45f))
            }

            Row {
                MyTextTitle(text = stringResource(R.string.targetCurrency),20, Modifier.weight(0.45f))
                Spacer(modifier = Modifier.weight(0.10f))
                MyTextTitle(text = stringResource(R.string.targetCurrency),20, Modifier.weight(0.45f))

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                DropDownList(20, Modifier.weight(0.45f))
                Spacer(modifier = Modifier.weight(0.10f))
                DropDownList(20, Modifier.weight(0.45f))
            }
            Row{
                ResultView("1",20,Modifier.weight(0.45f))
                Spacer(modifier = Modifier.weight(0.10f))
                ResultView("1",20,Modifier.weight(0.45f))

            }
            ButtonClickOn(
                buttonText = stringResource(R.string.compare),
                paddingTopValue = 40) {
                show = show.not()
            }
        }
    }
}