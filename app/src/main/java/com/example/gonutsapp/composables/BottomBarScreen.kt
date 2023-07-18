package com.example.gonutsapp.composables

import com.example.gonutsapp.R

sealed class BottomBarScreen(val route: String, val icon: Int = 0) {

    object Home : BottomBarScreen(route = HOME_ROUTE, icon = R.drawable.home)

    object Favorite : BottomBarScreen(route = FAVORITE_ROUTE, icon = R.drawable.heart)

    object Notification :
        BottomBarScreen(route = Notification_ROUTE, icon = R.drawable.notification)

    object Cart : BottomBarScreen(route = Cart_ROUTE, icon = R.drawable.cart)

    object Profile : BottomBarScreen(route = Profile_ROUTE, icon = R.drawable.person)

    object Details : BottomBarScreen(Details_ROUTE)

    object OnBoarding : BottomBarScreen(OnBoarding_ROUTE)

}

private const val HOME_ROUTE = "home_screen"
private const val FAVORITE_ROUTE = "favorite _screen"
private const val Notification_ROUTE = "notification_screen"
private const val Cart_ROUTE = "cart_screen"
private const val Profile_ROUTE = "profile_screen"
private const val Details_ROUTE = "details_screen"
private const val OnBoarding_ROUTE = "onboarding_screen"