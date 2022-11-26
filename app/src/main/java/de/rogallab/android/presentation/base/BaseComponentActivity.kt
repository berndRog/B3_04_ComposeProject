package de.rogallab.android.presentation.base

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle

open class BaseComponentActivity(
   private val _tag: String
) : ComponentActivity() {


   // Start of full lifetime, Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      Log.d(_tag, "onCreate()")
   }

   // Start of visible lifetime, Activity is visible
   override fun onStart() {
      super.onStart()
      Log.d(_tag, "onStart()")
   }

   // Start of the active lifetime, Activity interacts with the user
   override fun onResume() {
      super.onResume()
      Log.d(_tag, "onResume()")
   }

   // End of active lifetime, User is leaving activity
   override fun onPause() {
      Log.d(_tag, "onPause()")
      super.onPause()
   }

   // End of visible lifetime, Activity is no longer visible
   override fun onStop() {
      Log.d(_tag, "onStop()")
      super.onStop()
   }

   // End of full lifetime, Called before the activity is destroyed.
   override fun onDestroy() {
      Log.d(_tag, "onPause()")
      super.onDestroy()
   }

   // Activity is restarted
   override fun onRestart() {
      super.onRestart()
      Log.d(_tag, "onRestart()")
   }

   // override save/restore state methods -------------------------------------
   // Save instance state: invoked when the activity may be temporarily destroyed,
   override fun onSaveInstanceState(savedStateBundle: Bundle) {
      super.onSaveInstanceState(savedStateBundle)
      Log.d(_tag, "onSaveInstanceState()")
   }

   override fun onRestoreInstanceState(savedInstanceState: Bundle) {
      super.onRestoreInstanceState(savedInstanceState)
      Log.d(_tag, "onRestoreInstanceState()")
   }

   override fun onConfigurationChanged(newConfig: Configuration) {
      super.onConfigurationChanged(newConfig)

      // Checks the orientation of the screen
      if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
         Log.d(_tag, "landscape")
      } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
         Log.d(_tag, "portrait")
      }
   }

   override fun onWindowFocusChanged(hasFocus: Boolean) {
      Log.d(_tag, "onWindowFocusChanged() $hasFocus")
      super.onWindowFocusChanged(hasFocus)
   }

   override fun onBackPressed() {
      Log.d(_tag, "onBackPressed()")
      super.onBackPressed()
   }

   override fun onTrimMemory(level: Int) {
      super.onTrimMemory(level)
      Log.d(_tag, "onTrimMemory() $level")
      if (level == TRIM_MEMORY_RUNNING_MODERATE) Log.d(_tag, "TRIM_MEMORY_RUNNING_MODERATE")
      if (level == TRIM_MEMORY_RUNNING_LOW) Log.d(_tag, "TRIM_MEMORY_RUNNING_LOW")
      if (level == TRIM_MEMORY_RUNNING_CRITICAL) Log.d(_tag, "TRIM_MEMORY_RUNNING_CRITICAL")
      if (level == TRIM_MEMORY_BACKGROUND) Log.d(_tag, "TRIM_MEMORY_BACKGROUND")
      if (level == TRIM_MEMORY_COMPLETE) Log.d(_tag, "TRIM_MEMORY_COMPLETE")
      if (level == TRIM_MEMORY_UI_HIDDEN) Log.d(_tag, "TRIM_MEMORY_UI_HIDDEN")
      if (level == TRIM_MEMORY_MODERATE) Log.d(_tag, "TRIM_MEMORY_MODERATE")
   }
}