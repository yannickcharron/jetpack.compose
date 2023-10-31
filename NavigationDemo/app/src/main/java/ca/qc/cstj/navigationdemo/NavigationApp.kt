package ca.qc.cstj.navigationdemo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import ca.qc.cstj.navigationdemo.ui.components.BottomNavigationBar
import ca.qc.cstj.navigationdemo.ui.screens.analytics.AnalyticsScreen
import ca.qc.cstj.navigationdemo.ui.screens.home.HomeScreen
import ca.qc.cstj.navigationdemo.ui.screens.list.ListScreen
import ca.qc.cstj.navigationdemo.ui.screens.login.LoginScreen
import ca.qc.cstj.navigationdemo.ui.screens.profile.ProfileScreen

//https://nameisjayant.medium.com/nested-navigation-in-jetpack-compose-597ecdc6eebb

@Composable
fun NavigationApp(
    navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route, content = { LoginScreen(navController) })
        navigation(route = Screen.Home.route, startDestination = Screen.Profile.route) {
            composable(Screen.Profile.route) {
                BottomNavScreen(navController) {
                    ProfileScreen(navController)
                }
            }
            composable(Screen.Analytics.route)  { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("id")!!
                BottomNavScreen(navController) {
                    AnalyticsScreen(id.toInt())
                }
            }
            composable(Screen.List.route)  {
                BottomNavScreen(navController) {
                    ListScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(navController:NavHostController, content: @Composable () -> Unit) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        content()
    }
}

//sealed class Screens(@StringRes val title: Int) {
sealed class Screen(val title: String, val route: String) {

    object Login : Screen("Login", route = "login")
    object Home : Screen("Home", route = "home")
    object List : Screen("List", route = "list")
    object Analytics: Screen("Analytics", route = "analytics/{id}" )
    object Profile: Screen("Profile", route = "profile")

}