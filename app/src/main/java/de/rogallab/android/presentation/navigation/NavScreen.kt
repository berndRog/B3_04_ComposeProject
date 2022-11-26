package de.rogallab.android.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavScreen(
   val route: String,
   val resIdTitle: Int? = null,
   val icon: ImageVector? = null
) {
   object Main: NavScreen(
      route = "mainScreen"
   )
   object Second: NavScreen(
      route = "secondScreen"
   )
}