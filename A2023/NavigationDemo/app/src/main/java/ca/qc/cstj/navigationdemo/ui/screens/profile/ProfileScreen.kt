package ca.qc.cstj.navigationdemo.ui.screens.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ca.qc.cstj.navigationdemo.Screen
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ProfileScreen(navController: NavHostController, profileViewModel: ProfileViewModel = viewModel()) {

    val profileUIState by profileViewModel.profileUiState.collectAsStateWithLifecycle()

    when(val state = profileUIState) {
        is ProfileUIState.Error -> {
            Log.d("ProfileScreen:Error", state.toString())
        }
        ProfileUIState.Loading -> {
            Log.d("ProfileScreen:Loading", state.toString())
        }
        is ProfileUIState.Success -> {
            Log.d("ProfileScreen:Success", state.toString())
        }
        is ProfileUIState.NewState -> {
            Log.d("ProfileScreen:NewState", state.toString())
            Toast.makeText(LocalContext.current, state.message, Toast.LENGTH_LONG).show()
        }
    }
    Column {
        Button(onClick = { profileViewModel.changeState()}) {
            Text("Change State")
        }
    }
}

@Composable
fun ButtonWithURL(navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(BottomNavItem.Profile.title)
        Button(onClick = {
            val url = "https://google.ca"
            val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
            navController.navigate(Screen.Analytics.route.replace("{href}", encodedUrl))
        }) {
            Text("Ouvrir")
        }
    }
}