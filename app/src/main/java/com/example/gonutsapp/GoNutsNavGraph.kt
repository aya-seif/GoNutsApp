package com.example.gonutsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.gonutsapp.composables.BottomBarScreen
import com.example.gonutsapp.ui.cart.cartRoute
import com.example.gonutsapp.ui.details.detailsRoute
import com.example.gonutsapp.ui.favorite.favoriteRoute
import com.example.gonutsapp.ui.home.homeRoute
import com.example.gonutsapp.ui.notification.notificationRoute
import com.example.gonutsapp.ui.onboarding.onBoardingRoute
import com.example.gonutsapp.ui.profile.profileRoute

@Composable
fun GoNutsNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.OnBoarding.route
    ) {
        homeRoute(navController)
        favoriteRoute()
        notificationRoute()
        cartRoute()
        profileRoute()
        onBoardingRoute(navController)
        detailsRoute(navController)
    }
}