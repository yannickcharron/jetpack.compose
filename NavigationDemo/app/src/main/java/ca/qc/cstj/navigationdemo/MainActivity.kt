package ca.qc.cstj.navigationdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.qc.cstj.navigationdemo.ui.composables.BottomNavItem
import ca.qc.cstj.navigationdemo.ui.composables.BottomNavigationBar
import ca.qc.cstj.navigationdemo.ui.theme.NavigationDemoTheme


//https://bootcamp.uxdesign.cc/navigation-bar-with-jetpack-compose-32b052824b7d
//https://developer.android.com/jetpack/compose/navigation?hl=fr#kts
//https://developer.android.com/codelabs/basic-android-kotlin-compose-navigation?hl=fr#2

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.title,
            modifier = Modifier.padding(innerPadding),
            builder = {
                composable(BottomNavItem.Home.title, content =  { Text(BottomNavItem.Home.title) })
                composable(BottomNavItem.List.title, content =  { Text(BottomNavItem.List.title) })
                composable(BottomNavItem.Analytics.title, content =  { Text(BottomNavItem.Analytics.title) })
                composable(BottomNavItem.Profile.title, content =  { Text(BottomNavItem.Profile.title) })
        })
    }
}