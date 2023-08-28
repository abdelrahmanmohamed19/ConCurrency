package com.example.concurrency

import com.example.concurrency.data.dummyDataTesting.DummyCurrencyInfoList.getDummyCurrencyInfoList
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.ConvertRepository
import com.example.concurrency.presentation.convert.ConvertState
import com.example.concurrency.presentation.convert.ConvertViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Test

@ExperimentalCoroutinesApi
class ConvertViewModelTest {
    @Test
    fun loadingState_isSetCorrectly(){
        val viewModel = getViewModel()
        val state = viewModel.state.value

        val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())
        currenciesList.value = getDummyCurrencyInfoList()

        assert(
            state == ConvertState(
                allCurrencies = currenciesList.value,
                amount = "1",
                baseCurrency = currenciesList.value[0] !!,
                targetCurrency = currenciesList.value[0] !!,
                resultTarget = "1",
                isAmountError=false,
                amountErrorMessage="",
                isBaseDropDownExpend=false,
                isTargetDropDownExpend=false
            )
        )

    }

    private fun getViewModel(): ConvertViewModel {
        return ConvertViewModel(ConvertRepositoryImplTest())
    }

    // make fake class to test viewModel isolated
    class ConvertRepositoryImplTest : ConvertRepository{
        override suspend fun getAllCurrencies(): MutableStateFlow<List<CurrencyInfo?>> {
            val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())
            currenciesList.value = getDummyCurrencyInfoList()
            return currenciesList
        }

        override suspend fun convert(
            baseCurrency: String,
            targetCurrency: String,
            amount: String
        ): String? {
            return "0"
        }

    }
}