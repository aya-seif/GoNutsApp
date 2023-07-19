package com.example.gonutsapp.ui.details

import android.annotation.SuppressLint
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gonutsapp.composables.BottomBarScreen


fun NavController.navigateToDonutDetails(donutIndex: Int) {
    Log.d("TAG", "navigateToDonutDetails: $donutIndex")
    navigate("${BottomBarScreen.Details.route}/${donutIndex}")
}

fun NavController.navigateBackToHomeScreen() {
    navigate(BottomBarScreen.Home.route)
}

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.detailsRoute(navHostController: NavHostController) {
    composable(
        route = "${BottomBarScreen.Details.route}/{${DonutDetailsArgs.DONUT_ID}}",
        arguments = listOf(
            navArgument(DonutDetailsArgs.DONUT_ID){
                NavType.IntType
            }
        )
    ) {
        DetailsScreen(navHostController = navHostController)
    }
}