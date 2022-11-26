package de.rogallab.android.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.material.Surface
import de.rogallab.android.presentation.base.BaseComponentActivity
import de.rogallab.android.presentation.navigation.AppNavHost
import de.rogallab.android.presentation.theme.AppTheme

class MainActivity : BaseComponentActivity(_tag) {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      setContent {
         AppTheme() {
            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colors.background
            ) {
               AppNavHost()
            }
         }
      }
   }
   companion object {
      private val _tag = "ok>MainActivity       ."
   }
}