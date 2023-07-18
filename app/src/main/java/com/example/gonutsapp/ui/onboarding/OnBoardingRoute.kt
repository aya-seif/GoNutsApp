package com.example.gonutsapp.ui.onboarding

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.onBoardingRoute(){
    composable(BottomBarScreen.OnBoarding.route){
        OnBoardingScreen()
    }
}