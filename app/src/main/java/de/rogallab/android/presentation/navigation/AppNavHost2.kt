package de.rogallab.android.presentation.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.composable
import de.rogallab.android.presentation.composables.MainScreen2
import de.rogallab.android.presentation.SharedViewModel
import de.rogallab.android.presentation.composables.SecondScreen2

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost2(
) {         //12345678901234567890
   Log.d("==> AppNavHost     .", "Start()")

   val navHostController: NavHostController = rememberNavController()
   val viewModel: SharedViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

// https://medium.com/androiddevelopers/animations-in-navigation-compose-36d48870776b

   NavHost(
      navController = navHostController ,
      startDestination = NavScreen.Main.route
   ) {
      composable(
         route = NavScreen.Main.route,
      ) {
            MainScreen2(
               navController = navHostController,
               viewModel = viewModel
            )

      }

      composable(
         route = NavScreen.Second.route,
      ) {
            SecondScreen2(
               navController = navHostController,
               viewModel = viewModel
            )

      }
   }
}