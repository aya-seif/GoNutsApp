package com.example.gonutsapp.ui.profile

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.profileRoute() {
    composable(BottomBarScreen.Profile.route) {
        ProfileScreen()
    }
}