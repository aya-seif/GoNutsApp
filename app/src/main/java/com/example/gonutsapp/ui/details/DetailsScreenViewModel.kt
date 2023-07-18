package com.example.gonutsapp.ui.details

import androidx.lifecycle.ViewModel
import com.example.gonutsapp.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(

): ViewModel() {

    private val _uiState = MutableStateFlow(DetailsScreenUiState())
    val uiState = _uiState.asStateFlow()
}