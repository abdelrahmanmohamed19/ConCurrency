package com.example.concurrency.presentation.convert

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.concurrency.R
import com.example.concurrency.presentation.favorites.FavoritesViewModel
import com.example.concurrency.presentation.ui.ButtonClickOn
import com.example.concurrency.presentation.ui.DropDownList
import com.example.concurrency.presentation.ui.MyTextTitle
import com.example.concurrency.presentation.ui.ResultView
import com.example.concurrency.presentation.ui.SnackbarComponent
import com.example.concurrency.presentation.ui.UserEditText

@Composable
fun CurrencyConverterCard(viewModel: ConvertViewModel, favoritesViewModel: FavoritesViewModel) {
    val state = viewModel.state.value

    Column {
        Row {
            MyTextTitle(text = stringResource(R.string.amount), 0, Modifier.weight(0.40f))
            Spacer(modifier = Modifier.width(10.dp))
            MyTextTitle(text = stringResource(R.string.from), 0, Modifier.weight(0.60f))
        }
        Row {
            UserEditText(
                amount = state.amount,
                isAmountError = state.isAmountError,
                errorMessage = state.amountErrorMessage,
                onAmountChange = { newAmount -> viewModel.onAmountChange(newAmount) },
                paddingTop = 20,
                modifier = Modifier.weight(0.40f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            DropDownList(
                allCurrency = state.allCurrencies,
                selectedItem = state.baseCurrency,
                expanded = state.isBaseDropDownExpend,
                onDropDownClick = { viewModel.onBaseDropDownListClick() },
                onDropDownDismissClick = { viewModel.onDropDownListDismiss() },
                onDropDownSelectedItem = { selectedCurrency ->
                    viewModel.onBaseCurrencyChange(selectedCurrency)
                    favoritesViewModel.getExchangeRates(viewModel.state.value.baseCurrency.currencyCode.toString())
                },
                paddingTop = 20,
                modifier = Modifier.weight(0.60f)
            )
        }
        Row {
            AnimatedVisibility(visible = state.amountErrorMessage != "") {
                Text(text = state.amountErrorMessage, fontSize = 12.sp, color = Color.Red)
            }
        }
        Row {
            MyTextTitle(text = stringResource(R.string.to), 20, Modifier.weight(0.60f))
            Spacer(modifier = Modifier.width(10.dp))
            MyTextTitle(text = stringResource(R.string.amount), 20, Modifier.weight(0.40f))
        }
        Row {
            DropDownList(
                allCurrency = state.allCurrencies,
                selectedItem = state.targetCurrency,
                expanded = state.isTargetDropDownExpend,
                onDropDownClick = { viewModel.onTargetDropDownListClick() },
                onDropDownDismissClick = { viewModel.onDropDownListDismiss() },
                onDropDownSelectedItem = { selectedCurrency -> viewModel.onTargetCurrencyChange(selectedCurrency)},
                paddingTop = 20,
                Modifier.weight(0.60f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            ResultView(state.resultTarget, 20, Modifier.weight(0.40f))
        }

        ButtonClickOn(
            buttonText = stringResource(R.string.convert),
            paddingTopValue = 40
        ) {
            viewModel.onConvertClick()

        }

        if (!state.isNetworkAvailable) {
            SnackbarComponent("No internet connection")
        }
        else if (state.errorMessage != "") {
            SnackbarComponent("Error")
        }
    }


}
