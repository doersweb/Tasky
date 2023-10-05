package com.doersweb.tasky.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.doersweb.tasky.core.navigation.Routes
import com.doersweb.tasky.ui.theme.TaskyTheme
import navigate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskyTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.SPLASH) {
                    composable(Routes.SPLASH) {
                        SplashScreen(onNavigate = navController::navigate)
                    }
                    composable(Routes.LOGIN) {

                    }
                    composable(Routes.REGISTER) {

                    }
                }
            }
        }
    }
}