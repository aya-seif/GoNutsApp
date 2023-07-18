package com.example.gonutsapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity

@Composable
fun percentOfScreenHeight(percent: Int): Int {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    return with(LocalDensity.current) {
        (screenHeight * percent / 100)
    }
}
