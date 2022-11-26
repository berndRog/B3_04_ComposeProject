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
import de.rogallab.android.presentation.SharedViewModel
import de.rogallab.android.presentation.navigation.NavScreen
import de.rogallab.android.presentation.theme.paddings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SecondScreen2(
   navController: NavController,
   viewModel: SharedViewModel
) {

   Scaffold(
      topBar = { TopAppBar(
         title = { Text(text = stringResource(R.string.app_name))}
      )}
   ) {
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
            text = viewModel.name,                            // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )
         Text(
            text = viewModel.email,                           // State ↓
            modifier = Modifier
               .padding(vertical = MaterialTheme.paddings.small),
            style = MaterialTheme.typography.body1,
         )

         OutlinedTextField(
            value = viewModel.street,                          // State ↓
            onValueChange = { viewModel.onStreetChanged(it) }, // Event ↑
            modifier = Modifier.fillMaxWidth(),
            label = { Text( text = stringResource(R.string.street)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
         )

         OutlinedTextField(
            value = viewModel.city,                           // State ↓
            onValueChange = { viewModel.onCityChanged(it)},        // Event ↑
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
               Log.d("==> MainScreen     .", "OnClickHandler()")
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