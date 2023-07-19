package com.example.gonutsapp.ui.details

import androidx.lifecycle.SavedStateHandle

class DonutDetailsArgs (savedStateHandle: SavedStateHandle) {

    val donutIndex : String = checkNotNull(savedStateHandle[DONUT_ID])

    companion object {
        const val DONUT_ID = "donut_id"
    }
}