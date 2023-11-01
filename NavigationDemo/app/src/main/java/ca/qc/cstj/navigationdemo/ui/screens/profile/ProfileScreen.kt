package ca.qc.cstj.navigationdemo.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ca.qc.cstj.navigationdemo.Screen
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(BottomNavItem.Profile.title)
        Button(onClick = {
            val url = "https://api.andromia.science/allies/actions?type=generate"
            val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
            navController.navigate(Screen.Analytics.route.replace("{href}", encodedUrl))
        }) {
            Text("Ouvrir")
        }
    }
}