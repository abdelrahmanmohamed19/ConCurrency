package com.example.concurrency.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun CurrencyConverterCard (viewModel: HomeViewModel) {
    var show by remember { mutableStateOf(false) }

    Column {
        Row {
            MyTextTitle(text = stringResource(R.string.amount), 0, Modifier.weight(0.40f))
            Spacer(modifier = Modifier.width(10.dp))
            MyTextTitle(text = stringResource(R.string.from), 0, Modifier.weight(0.60f))
        }
        Row {
            UserEditText(20, modifier = Modifier.weight(0.40f))
            Spacer(modifier = Modifier.width(10.dp))
            DropDownList(20, modifier = Modifier.weight(0.60f))
        }

        Row {
            MyTextTitle(text = stringResource(R.string.to), 20, Modifier.weight(0.60f))
            Spacer(modifier = Modifier.width(10.dp))
            MyTextTitle(text = stringResource(R.string.amount), 20, Modifier.weight(0.40f))
        }
        Row {
            DropDownList(20, Modifier.weight(0.60f))
            Spacer(modifier = Modifier.width(10.dp))
            ResultView("1", 20, Modifier.weight(0.40f))
        }

        ButtonClickOn(
            buttonText = stringResource(R.string.convert),
            paddingTopValue = 40
        ) {
            show = show.not()
        }
    }


}
