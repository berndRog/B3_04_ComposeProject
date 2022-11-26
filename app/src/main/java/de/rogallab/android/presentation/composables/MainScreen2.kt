package de.rogallab.android.presentation.composables

import android.annotation.SuppressLint
import android.util.Log
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
import de.rogallab.android.presentation.SharedViewModel
import de.rogallab.android.presentation.navigation.NavScreen
import de.rogallab.android.presentation.theme.paddings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen2(
   navController: NavController,
   viewModel: SharedViewModel
) {

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

         Text(
            text = stringResource(R.string.main_caption),
            modifier = Modifier.padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.h6
         )

         OutlinedTextField(
            value = viewModel.name,                          // State ↓
            onValueChange = { viewModel.onNameChange(it) }, // Event ↑
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.name))},
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
         )

         OutlinedTextField(
            value = viewModel.email,                          // State ↓
            onValueChange = { viewModel.onEmailChange(it) }, // Event ↑
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
               Log.d("==> MainScreen     .", "OnClick()")
               // Navigate to SecondScreen
               // Pop everything up to the Main" destination off the back stack
               // before navigating to the "Second" destination
               navController.navigate(route = NavScreen.Second.route) {
                  // popUpTo(route = NavScreen.Main.route) //{ inclusive = true }
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
            text = viewModel.street,                      // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )
         Text(
            text = viewModel.city,                        // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )
      }
   }
}