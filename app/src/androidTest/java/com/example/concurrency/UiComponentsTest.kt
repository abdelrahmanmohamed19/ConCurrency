package com.example.concurrency

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.example.concurrency.data.dummyDataTesting.DummyCurrencyInfoList.getDummyCurrencyInfoList
import com.example.concurrency.presentation.ui.DialogueFavoritesList
import com.example.concurrency.presentation.ui.DropDownList
import com.example.concurrency.ui.theme.ConCurrencyTheme
import org.junit.Rule
import org.junit.Test

class UiComponentsTest {
    private val currenciesList = getDummyCurrencyInfoList()
    private val currencyItem = currenciesList[0]


    @get:Rule
    val testRule: ComposeContentTestRule = createComposeRule()

    @Test
    fun onDialogItemClick_FavoriteCurrencyPassedCorrectly(){


        testRule.setContent {
            ConCurrencyTheme{
                DialogueFavoritesList(
                    currencyList = currenciesList,
                    isShowDialog = true,
                    onSelectFavoriteCurrency = {currencyInfo ->
                        assert(currencyItem.currencyCode == currencyInfo.currencyCode)

                    },
                    onDialogDismiss = {},
                )
            }
        }
        testRule.onNodeWithText(currencyItem.name.toString()).performClick()

    }

    @Test
    fun onDropDownItemClick_CurrencySelectedCorrectly(){
        val checkCurrencySelected = currenciesList[2]

        testRule.setContent {
            ConCurrencyTheme{
                DropDownList(
                    allCurrency = currenciesList,
                    selectedItem = currencyItem,
                    expanded = true,
                    onDropDownClick = { /*TODO*/ },
                    onDropDownDismissClick = { /*TODO*/ },
                    onDropDownSelectedItem = {selectedItem->
                        assert(checkCurrencySelected.currencyCode == selectedItem.currencyCode)
                    },
                    modifier = Modifier.padding(5.dp),
                )
            }
        }
        testRule.onNodeWithText("${checkCurrencySelected.currencyCode} - ${   checkCurrencySelected.name}").performClick()

    }




}

