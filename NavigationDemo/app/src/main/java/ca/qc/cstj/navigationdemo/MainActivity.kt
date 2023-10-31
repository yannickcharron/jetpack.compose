package ca.qc.cstj.navigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import ca.qc.cstj.navigationdemo.ui.components.BottomNavigationBar
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
                NavigationApp()
            }
        }
    }
}

