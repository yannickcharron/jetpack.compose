package ca.qc.cstj.navigationdemo.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ca.qc.cstj.navigationdemo.Screen

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(Screen.Login.title)
        Button(onClick = { navController.navigate(Screen.Profile.route) }) {
            Text("Login")
        }
    }
}