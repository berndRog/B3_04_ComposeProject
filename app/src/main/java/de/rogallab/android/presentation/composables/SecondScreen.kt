package de.rogallab.android.presentation.composables
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import de.rogallab.android.R
import de.rogallab.android.presentation.base.LogComp
import de.rogallab.android.presentation.base.LogFun
import de.rogallab.android.presentation.navigation.NavScreen
import de.rogallab.android.presentation.theme.paddings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SecondScreen(
   navController: NavController,
   name: String,                                 // State ↓
   email: String,                                // State ↓
   street: String,                               // State ↓
   onStreetChange: (String) -> Unit,             // Event ↓
   city: String,                                 // State ↓
   onCityChange: (String) -> Unit,               // Event ↓
) {

   val tag: String = "ok>SecondScreen       ."
   Scaffold(
      topBar = { TopAppBar(
         title = { Text(text = stringResource(R.string.app_name))}
      )}
   ) {

      LogComp(tag, "Content")

      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.paddings.small)
      ) {

         Text(
            text = stringResource(R.string.second_caption),
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.h6,
         )

         Text(
            text = name,                         // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )
         Text(
            text = email,                        // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )

         OutlinedTextField(
            value = street,                      // State ↓
            onValueChange = onStreetChange,      // Event ↑
            modifier = Modifier.fillMaxWidth(),
            label = { Text( text = stringResource(R.string.street)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
         )

         OutlinedTextField(
            value = city,                         // State ↓
            onValueChange = onCityChange,         // Event ↑
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.city)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
         )

         Button(
            modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = MaterialTheme.paddings.medium),
            onClick = {
               LogFun("==> SecondScreen   .", "OnClickHandler()")
               // Navigate to SecondScreen()
               // Pop everything up to and including the "Second" destination off
               // the back stack before navigating to the "Main" destination
               navController.navigate(route = NavScreen.Main.route) {
                  popUpTo(route = NavScreen.Main.route) { inclusive = true }
               }
            }
         ) {
            Text(
               text = stringResource(R.string.back),
               modifier = Modifier
                  .padding(vertical = MaterialTheme.paddings.small),
               style = MaterialTheme.typography.button,
               textAlign = TextAlign.Center
            )
         }
      }
   }
}