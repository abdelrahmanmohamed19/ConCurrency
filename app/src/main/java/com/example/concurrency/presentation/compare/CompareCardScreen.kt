package com.example.concurrency.presentation.compare

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.concurrency.R
import com.example.concurrency.presentation.ui.ButtonClickOn
import com.example.concurrency.presentation.ui.DropDownList
import com.example.concurrency.presentation.ui.MyTextTitle
import com.example.concurrency.presentation.ui.ResultView
import com.example.concurrency.presentation.ui.UserEditText


@Composable
fun CurrencyCompareScreen (viewModel : CompareViewModel) {
    var show by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxHeight().padding(start = 20.dp , end = 20.dp , bottom = 100.dp),
    ) {
            Row {
                MyTextTitle(text = stringResource(R.string.amount), 0, Modifier.weight(0.50f))
                Spacer(modifier = Modifier.weight(0.10f))
                MyTextTitle(text = stringResource(R.string.from), 0, Modifier.weight(0.50f))

            }
            Row {
                UserEditText(20, modifier = Modifier.weight(0.48f))
                Spacer(modifier = Modifier.weight(0.04f))
                DropDownList(20, modifier = Modifier.weight(0.48f))
            }

            Row {
                MyTextTitle(
                    text = stringResource(R.string.targetCurrency),
                    20,
                    Modifier.weight(0.45f)
                )
                Spacer(modifier = Modifier.weight(0.10f))
                MyTextTitle(
                    text = stringResource(R.string.targetCurrency),
                    20,
                    Modifier.weight(0.45f)
                )

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                DropDownList(20, Modifier.weight(0.48f))
                Spacer(modifier = Modifier.weight(0.04f))
                DropDownList(20, Modifier.weight(0.48f))
            }
            Row {
                ResultView("1", 20, Modifier.weight(0.48f))
                Spacer(modifier = Modifier.weight(0.04f))
                ResultView("1", 20, Modifier.weight(0.48f))

            }
            ButtonClickOn(
                buttonText = stringResource(R.string.compare),
                paddingTopValue = 40
            ) {
                show = show.not()
            }
        }
    }
