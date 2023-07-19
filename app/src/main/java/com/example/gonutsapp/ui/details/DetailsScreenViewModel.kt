package com.example.gonutsapp.ui.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.gonutsapp.data.GoNutsDataSource
import com.example.gonutsapp.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.NumberFormatException
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val goNutsDataSource: GoNutsDataSource,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val args = DonutDetailsArgs(savedStateHandle)
    private val donutIndex = args.donutIndex

    init {
        getDonutDetails()
    }

    private fun getDonutDetails() {
        val dountDetail = goNutsDataSource.getDonutOffers()[Integer.parseInt(donutIndex)]
        Log.d("TASSSSSSSS", "getDonutDetails:$dountDetail ")
        _uiState.update {
            it.copy(
                image = dountDetail.image,
                name = dountDetail.name,
                description = dountDetail.description,
                price = dountDetail.originalPrice
            )
        }
    }
}