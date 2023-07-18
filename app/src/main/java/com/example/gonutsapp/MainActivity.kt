package com.example.gonutsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gonutsapp.composables.BottomBar
import com.example.gonutsapp.composables.BottomBarScreen
import com.example.gonutsapp.ui.details.DetailsScreen
import com.example.gonutsapp.ui.home.HomeScreen
import com.example.gonutsapp.ui.onboarding.OnBoardingScreen
import com.example.gonutsapp.ui.theme.GoNutsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoNutsAppTheme {
                val navController = rememberNavController()
                val bottomBarState = checkBottomBarState(navController = navController)
                Scaffold(
                    Modifier.fillMaxHeight(),
                    bottomBar = {
                        BottomBar(navController, bottomBarState)
                    }
                )
                { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        GoNutsNavGraph(navController)
                    }
                }
            }
        }
    }
}

@Composable
private fun checkBottomBarState(navController: NavHostController): MutableState<Boolean> {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val bottomBarScreens = listOf(
        BottomBarScreen.Home.route,
        BottomBarScreen.Favorite.route,
        BottomBarScreen.Notification.route,
        BottomBarScreen.Cart.route,
        BottomBarScreen.Profile.route,
    )

    when (navBackStackEntry?.destination?.route) {
        in bottomBarScreens -> {
            // Show BottomBar
            bottomBarState.value = true
        }

        else -> {
            // Hide BottomBar
            bottomBarState.value = false
        }
    }
    return bottomBarState
}
