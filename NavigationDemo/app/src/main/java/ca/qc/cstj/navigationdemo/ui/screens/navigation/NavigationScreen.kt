package ca.qc.cstj.navigationdemo.ui.screens.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NavigationScreen(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }
}