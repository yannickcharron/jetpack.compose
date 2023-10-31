package ca.qc.cstj.navigationdemo.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(BottomNavItem.Profile.title)
    }
}