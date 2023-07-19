package com.example.gonutsapp.ui.onboarding

import android.annotation.SuppressLint
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.onBoardingRoute(navController: NavHostController){
    composable(BottomBarScreen.OnBoarding.route){
        OnBoardingScreen(navController)
    }
}

fun NavController.navigateToHomeScreen(){
    navigate(BottomBarScreen.Home.route)
}