package com.example.concurrency

import com.example.concurrency.data.dummyDataTesting.DummyCurrencyInfoList
import com.example.concurrency.data.dummyDataTesting.DummyCurrencyInfoList.getDummyCurrencyInfoList
import com.example.concurrency.data.remote.dto.CompareRequestBody
import com.example.concurrency.data.remote.dto.ConversionRates
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.domain.repository.CompareRepository
import com.example.concurrency.presentation.compare.CompareState
import com.example.concurrency.presentation.compare.CompareViewModel
import com.example.concurrency.presentation.convert.ConvertState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Test

@ExperimentalCoroutinesApi
class CompareViewModelTest {

    @Test
    fun loadingState_isSetCorrectly(){
        val viewModel = getViewModel()
        val state = viewModel.state.value

        val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())
        currenciesList.value = getDummyCurrencyInfoList()

        assert(
            state == CompareState(
                allCurrencies = currenciesList.value,
                amount = "1",
                baseCurrency = currenciesList.value[0] !!,
                firstTargetCurrency = currenciesList.value[0] !!,
                secondTargetCurrency = currenciesList.value[0] !!,
                firstResultTarget = "1",
                secondResultTarget = "1",
                isAmountError=false,
                amountErrorMessage="",
                isBaseDropDownExpend=false,
                isFirstTargetDropDownExpend=false,
                isSecondTargetDropDownExpend=false,
            )
        )

    }


    private fun getViewModel():CompareViewModel {
        return CompareViewModel(CompareRepositoryImplTest())
    }

    class CompareRepositoryImplTest :CompareRepository{
        override suspend fun getAllCurrencies(): MutableStateFlow<List<CurrencyInfo?>> {
            val currenciesList = MutableStateFlow(emptyList<CurrencyInfo?>())
            currenciesList.value = DummyCurrencyInfoList.getDummyCurrencyInfoList()
            return currenciesList
        }

        override suspend fun compare(compareRequestBody: CompareRequestBody): ConversionRates {
            return ConversionRates(14.5, 0.547)
        }


    }
}