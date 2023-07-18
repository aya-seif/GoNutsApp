package com.example.gonutsapp.ui.favorite

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.favoriteRoute(){
    composable(BottomBarScreen.Favorite.route){
        FavoriteScreen()
    }
}