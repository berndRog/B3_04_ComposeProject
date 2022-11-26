package de.rogallab.android.presentation.navigation

import android.util.Log
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable
import de.rogallab.android.presentation.composables.MainScreen
import de.rogallab.android.presentation.composables.SecondScreen
import de.rogallab.android.presentation.SharedViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(
) {         //12345678901234567890
   Log.d("==> AppNavHost     .", "Start()")

// val navHostController: NavHostController = rememberNavController()
   val navHostController = rememberAnimatedNavController()
   val viewModel: SharedViewModel = viewModel()

// https://medium.com/androiddevelopers/animations-in-navigation-compose-36d48870776b

// NavHost(
   AnimatedNavHost(
      navController = navHostController ,
      startDestination = NavScreen.Main.route
   ) {
      composable(
         route = NavScreen.Main.route,
         enterTransition = {
            when (initialState.destination.route) {
               NavScreen.Second.route ->
                  slideIntoContainer(
                     AnimatedContentScope.SlideDirection.Left,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         },
         exitTransition = {
            when (targetState.destination.route) {
               NavScreen.Second.route ->
                  slideOutOfContainer(
                     AnimatedContentScope.SlideDirection.Left,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         },
         popEnterTransition = {
            when (initialState.destination.route) {
               NavScreen.Second.route ->
                  slideIntoContainer(
                     AnimatedContentScope.SlideDirection.Right,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         },
         popExitTransition = {
            when (targetState.destination.route) {
               NavScreen.Second.route ->
                  slideOutOfContainer(
                     AnimatedContentScope.SlideDirection.Right,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         }
      ) {
            MainScreen(
               navController  = navHostController,
               name           =   viewModel.name,                // State ↓
               onNameChange   = { viewModel.onNameChange(it) },  // Event ↑
               email          =   viewModel.email,               // State ↓
               onEmailChange  = { viewModel.onEmailChange(it) }, // Event ↑
               street         =   viewModel.street,              // State ↓
               city           =   viewModel.city                 // State ↓
            )

      }

      composable(
         route = NavScreen.Second.route,
         enterTransition = {
            when (initialState.destination.route) {
               NavScreen.Main.route ->
                  slideIntoContainer(
                     AnimatedContentScope.SlideDirection.Left,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         },
         exitTransition = {
            when (targetState.destination.route) {
               NavScreen.Main.route ->
                  slideOutOfContainer(
                     AnimatedContentScope.SlideDirection.Left,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         },
         popEnterTransition = {
            when (initialState.destination.route) {
               NavScreen.Main.route ->
                  slideIntoContainer(
                     AnimatedContentScope.SlideDirection.Right,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         },
         popExitTransition = {
            when (targetState.destination.route) {
               NavScreen.Main.route ->
                  slideOutOfContainer(
                     AnimatedContentScope.SlideDirection.Right,
                     animationSpec = tween(700)
                  )
               else -> null
            }
         }
      ) {
            SecondScreen(
               navController = navHostController,
               name            =   viewModel.name,                   // State ↓
               email           =   viewModel.email,                  // State ↓
               street          =   viewModel.street,                 // State ↓
               onStreetChange = { viewModel.onStreetChanged(it) },  // Event ↑
               city            = viewModel.city,                     // State ↓
               onCityChange   = { viewModel.onCityChanged(it) }     // Event ↑
            )

      }
   }
}