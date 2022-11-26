package de.rogallab.android.presentation.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import de.rogallab.android.R
import de.rogallab.android.presentation.base.LogComp
import de.rogallab.android.presentation.base.LogFun
import de.rogallab.android.presentation.navigation.NavScreen
import de.rogallab.android.presentation.theme.paddings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
   navController: NavController,
   name: String,                                 // State ↓
   onNameChange: (String) -> Unit,               // Event ↑
   email: String,                                // State ↓
   onEmailChange: (String) -> Unit,              // Event ↑
   street: String,                               // State ↓
   city: String,                                 // State ↓

) {

// var name  by remember {  mutableStateOf("")  }
// var email by remember {  mutableStateOf("")  }

   val tag: String = "ok>MainScreen         ."

   Scaffold(
      topBar = { TopAppBar(
         title = {Text(text = stringResource(R.string.app_name))}
      )}
   ) {

      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(all = MaterialTheme.paddings.small)
      ) {

         LogComp(tag, "Content")

         Text(
            text = stringResource(R.string.main_caption),
            modifier = Modifier.padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.h6
         )

         OutlinedTextField(
            value = name,                        // State ↓
//          onValueChange = { name = it },
            onValueChange = onNameChange,        // Event ↑
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.name))},
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
         )

         OutlinedTextField(
            value = email,                       // State ↓
//          onValueChange = { email = it },
            onValueChange = onEmailChange,       // Event ↑
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.email)) },
            textStyle = MaterialTheme.typography.body1,
            keyboardOptions = KeyboardOptions(
               keyboardType = KeyboardType.Email
            ),
            singleLine = true,
         )

         Button(
            modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = MaterialTheme.paddings.medium),
            onClick = {
               LogFun(tag, "onClick()")
               // Navigate to SecondScreen
               // Pop everything up to the Main" destination off the back stack
               // before navigating to the "Second" destination
               navController.navigate(route = NavScreen.Second.route) {
//                // popUpTo(route = NavScreen.Main.route) //{ inclusive = true }
                   launchSingleTop = true
               }
            }
         ) {
            Text(
               text = stringResource(R.string.send),
               modifier = Modifier
                  .padding(vertical = MaterialTheme.paddings.small),
               style = MaterialTheme.typography.button,
               textAlign = TextAlign.Center
            )
         }

         Text(
            text = street,                      // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )
         Text(
            text = city,                        // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )
      }
  }
}