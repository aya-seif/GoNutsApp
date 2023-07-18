package com.example.gonutsapp.ui.home

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.homeRoute(){
    composable(BottomBarScreen.Home.route){
        HomeScreen()
    }
}