package ca.qc.cstj.navigationdemo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
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
import ca.qc.cstj.navigationdemo.ui.screens.navigation.NavigationScreen
import ca.qc.cstj.navigationdemo.ui.screens.profile.ProfileScreen
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanQRCode

//https://nameisjayant.medium.com/nested-navigation-in-jetpack-compose-597ecdc6eebb



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp() {
    val navController = rememberNavController()

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
fun NavigationAppV2() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPaddings ->
        Surface(modifier = Modifier.padding(innerPaddings)) {
            NavHost(navController = navController, startDestination = Screen.Profile.route ) {
                composable(Screen.Profile.route) {
                    NavigationScreen("Analytics") { navController.navigate(Screen.Analytics.route) }
                }
                composable(Screen.Analytics.route) {
                    NavigationScreen("Profile") { navController.navigate(Screen.Profile.route) }
                }
                composable(Screen.List.route) {
                    ListScreen()
                }
            }
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppV3() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPaddings ->
        Surface(modifier = Modifier.padding(innerPaddings)) {
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
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(navController: NavHostController, content: @Composable () -> Unit) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPaddings ->
        Surface(modifier = Modifier.padding(innerPaddings)) {
            content()
        }
    }
}

//sealed class Screens(@StringRes val title: Int) {
sealed class Screen(val title: String, val route: String, val icon: ImageVector) {

    object Login : Screen("Login", route = "login", icon = Icons.Default.AccountBox)
    object Home : Screen("Home", route = "home", icon = Icons.Default.Home)
    object List : Screen("List", route = "list", icon = Icons.Default.List)
    object Analytics: Screen("Analytics", route = "analytics/{href}" , icon = Icons.Default.Favorite)
    object Profile: Screen("Profile", route = "profile", icon = Icons.Default.Face)
    object Camera: Screen("Camera", route = "camera", icon = Icons.Default.Notifications)


}