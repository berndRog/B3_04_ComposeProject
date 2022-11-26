package de.rogallab.android.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import de.rogallab.android.model.Person

class SharedViewModel() : ViewModel() {

   private var person: Person = Person()

   // MainScreen State
   var name: String by mutableStateOf(value = "")
      private set
   var email: String by mutableStateOf(value = "")
      private set
   // MainScreen Event (String) -> Unit
   fun onNameChange(name: String) {
      this.name = name
   }
   fun onEmailChange(email: String) {
      this.email = email
   }

   // State SecondScreen
   var street: String by mutableStateOf(value = "")
      private set
   var city: String by mutableStateOf(value = "")
      private set
   // SecondScreen Event (String) -> Unit
   fun onStreetChanged(street: String) {
      this.street = street
   }
   fun onCityChanged(city: String) {
      this.city = city
   }

   override fun onCleared() {
      Log.d(TAG, "onCleared()")
      super.onCleared()
   }

   companion object {
      private const val TAG = "==> SharedViewModel."
   }
}