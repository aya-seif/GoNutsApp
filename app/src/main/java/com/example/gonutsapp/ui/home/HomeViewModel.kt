package com.example.gonutsapp.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistry
import com.example.gonutsapp.data.GoNutsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val goNutsDataSource: GoNutsDataSource,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()
    private val registry: SavedStateRegistry ? = null

    init {
        getDonutsOffer()
        getDonuts()
    }

    private fun getDonutsOffer() {
        val donutOffers = goNutsDataSource.getDonutOffers()
        _uiState.update { it.copy(donutOffers = donutOffers) }
    }

    private fun getDonuts() {
        val donuts = goNutsDataSource.getDonuts()
        _uiState.update { it.copy(donutsList = donuts) }
    }

}