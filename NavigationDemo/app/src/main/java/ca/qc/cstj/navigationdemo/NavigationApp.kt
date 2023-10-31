package ca.qc.cstj.navigationdemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.qc.cstj.navigationdemo.ui.screens.home.HomeScreen
import ca.qc.cstj.navigationdemo.ui.screens.login.LoginScreen

@Composable
fun NavigationApp(
    navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        builder = {
            composable(Screen.Login.title, content =  { LoginScreen(navController) })
            composable(Screen.Home.title, content =  { HomeScreen() })

    })
}

//sealed class Screens(@StringRes val title: Int) {
sealed class Screen(val title: String, val route: String) {

    object Login : Screen("Login", route = "login")
    object Home : Screen("Home", route = "home")
    object List : Screen("List", route = "list")
    object Analytics: Screen("Analytics", route = "analytics" )
    object Profile: Screen("Profile", route = "profile")

}