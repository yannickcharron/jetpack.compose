package ca.qc.cstj.navigationdemo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import ca.qc.cstj.navigationdemo.ui.screens.camera.CameraScreen
import ca.qc.cstj.navigationdemo.ui.screens.home.HomeScreen
import ca.qc.cstj.navigationdemo.ui.screens.list.ListScreen
import ca.qc.cstj.navigationdemo.ui.screens.login.LoginScreen
import ca.qc.cstj.navigationdemo.ui.screens.profile.ProfileScreen
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanQRCode

//https://nameisjayant.medium.com/nested-navigation-in-jetpack-compose-597ecdc6eebb



@Composable
fun NavigationApp(
    navController: NavHostController = rememberNavController()) {



    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
    ) {
        composable(Screen.Login.route, content = { LoginScreen(navController)})
        navigation(route = Screen.Home.route, startDestination = Screen.Profile.route) {
            composable(Screen.Profile.route) {
                BottomNavScreen(navController) {
                    ProfileScreen(navController)
                }
            }
            composable(Screen.Analytics.route)  { navBackStackEntry ->
                //https://medium.com/@daniel.atitienei/navigate-with-arguments-in-jetpack-compose-90846d70bb7f/
                val href = navBackStackEntry.arguments?.getString("href")!!
                BottomNavScreen(navController) {
                    AnalyticsScreen(href)
                }
            }
            composable(Screen.List.route)  {
                BottomNavScreen(navController) {
                    ListScreen()
                }
            }
            composable(Screen.Camera.route) {
                CameraScreen(navController)
            }


        }

    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(navController:NavHostController, content: @Composable () -> Unit) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPaddings ->
        Surface(modifier = Modifier.padding(innerPaddings)) {
            content()
        }
    }
}

//sealed class Screens(@StringRes val title: Int) {
sealed class Screen(val title: String, val route: String) {

    object Login : Screen("Login", route = "login")
    object Home : Screen("Home", route = "home")
    object List : Screen("List", route = "list")
    object Analytics: Screen("Analytics", route = "analytics/{href}" )
    object Profile: Screen("Profile", route = "profile")
    object Camera: Screen("Camera", route = "camera")


}