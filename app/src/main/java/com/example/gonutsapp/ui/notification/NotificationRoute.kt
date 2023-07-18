package com.example.gonutsapp.ui.notification

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonutsapp.composables.BottomBarScreen

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.notificationRoute(){
    composable(BottomBarScreen.Notification.route){
        NotificationScreen()
    }
}