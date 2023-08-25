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
import com.example.concurrency.presentation.allCurrency
import com.example.concurrency.presentation.ui.ButtonClickOn
import com.example.concurrency.presentation.ui.DropDownList
import com.example.concurrency.presentation.ui.MyTextTitle
import com.example.concurrency.presentation.ui.ResultView
import com.example.concurrency.presentation.ui.UserEditText


@Composable
fun CurrencyCompareScreen (viewModel : CompareViewModel) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 20.dp),
    ) {
            Row {
                MyTextTitle(text = stringResource(R.string.amount), 0, Modifier.weight(0.50f))
                Spacer(modifier = Modifier.weight(0.10f))
                MyTextTitle(text = stringResource(R.string.from), 0, Modifier.weight(0.50f))
            }

            Row {
                UserEditText(
                    amount = state.amount,
                    amountErrorMessage = state.amountErrorMessage,
                    isAmountError = state.isAmountError,
                    onAmountChange = {newAmount -> viewModel.onAmountChange(newAmount) } ,
                    paddingTop = 20,
                    modifier = Modifier.weight(0.48f)
                )
                Spacer(modifier = Modifier.weight(0.04f))
                DropDownList(
                    allCurrency = state.allCurrencys,
                    selectedItem = state.baseCurrency,
                    expanded = state.isBaseDropDownExpend,
                    onDropDownClick = {viewModel.onBaseDropDownListClick()},
                    onDropDownDismissClick = {viewModel.onDropDownListDismiss()},
                    onDropDownSelectedItem = {newCurrency -> viewModel.onBaseCurrencyChange(newCurrency)},
                    modifier = Modifier.weight(0.48f),
                    paddingTop = 20
                )
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
                DropDownList(
                    allCurrency = state.allCurrencys,
                    selectedItem = state.firstTargetCurrency,
                    expanded = state.isFirstTargetDropDownExpend,
                    onDropDownClick = {viewModel.onFirstDropDownListClick()},
                    onDropDownDismissClick = {viewModel.onDropDownListDismiss()},
                    onDropDownSelectedItem = {newCurrency -> viewModel.onFirstTargetCurrencyChange(newCurrency)},
                    modifier = Modifier.weight(0.48f),
                    paddingTop = 20
                )
                Spacer(modifier = Modifier.weight(0.04f))
                DropDownList(
                    allCurrency = state.allCurrencys,
                    selectedItem = state.secondTargetCurrency,
                    expanded = state.isSecondTargetDropDownExpend,
                    onDropDownClick = {viewModel.onSecondDropDownListClick()},
                    onDropDownDismissClick = {viewModel.onDropDownListDismiss()},
                    onDropDownSelectedItem = {newCurrency -> viewModel.onSecondTargetCurrencyChange(newCurrency)},
                    modifier = Modifier.weight(0.48f),
                    paddingTop = 20
                )
            }
            Row {
                ResultView(state.firstResultTarget, 20, Modifier.weight(0.48f))
                Spacer(modifier = Modifier.weight(0.04f))
                ResultView(state.secondResultTarget, 20, Modifier.weight(0.48f))

            }
            ButtonClickOn(
                buttonText = stringResource(R.string.compare),
                paddingTopValue = 40
            ) {
                viewModel.onCompareClick()
            }
        }
    }
