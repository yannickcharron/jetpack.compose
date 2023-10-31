package ca.qc.cstj.navigationdemo.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.qc.cstj.navigationdemo.Screen
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import ca.qc.cstj.navigationdemo.ui.components.BottomNavigationBar
import ca.qc.cstj.navigationdemo.ui.screens.analytics.AnalyticsScreen
import ca.qc.cstj.navigationdemo.ui.screens.list.ListScreen
import ca.qc.cstj.navigationdemo.ui.screens.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController : NavHostController = rememberNavController()) {

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Profile.title,
            modifier = Modifier.padding(innerPadding),
            builder = {
                composable(Screen.Profile.title, content =  { ProfileScreen() })
                composable(Screen.List.title, content =  { ListScreen() })
                composable(Screen.Analytics.title, content =  { AnalyticsScreen() })
            })
    }
}