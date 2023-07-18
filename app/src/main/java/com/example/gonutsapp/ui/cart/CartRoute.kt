package com.example.gonutsapp.ui.cart

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.cartRoute() {
    composable(BottomBarScreen.Cart.route) {
        CartScreen()
    }
}