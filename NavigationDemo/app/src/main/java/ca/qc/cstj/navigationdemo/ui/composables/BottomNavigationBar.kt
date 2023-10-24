package ca.qc.cstj.navigationdemo.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import ca.qc.cstj.navigationdemo.R

//https://bootcamp.uxdesign.cc/navigation-bar-with-jetpack-compose-32b052824b7d


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.List,
        BottomNavItem.Analytics,
        BottomNavItem.Profile
    )

    NavigationBar {
        items.forEach {
            AddItem(screen = it, navController)
        }
    }

}

@Composable
fun RowScope.AddItem(screen: BottomNavItem, navController: NavController) {
    NavigationBarItem(
        label = { Text(text = screen.title)},
        selected = true,
        onClick = { navController.navigate(screen.title) },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = screen.title) },
        colors = NavigationBarItemDefaults.colors()
    )
}

sealed class BottomNavItem(var title: String, var icon: Int) {
    object Home: BottomNavItem("Home", R.drawable.baseline_home_24)
    object List: BottomNavItem("List", R.drawable.baseline_list_24)
    object Analytics: BottomNavItem("Analytics", R.drawable.baseline_analytics_24)
    object Profile: BottomNavItem("Profile", R.drawable.baseline_person_24)

}
