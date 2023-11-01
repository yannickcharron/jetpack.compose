package ca.qc.cstj.navigationdemo.ui.screens.analytics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem

@Composable
fun AnalyticsScreen(href: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(BottomNavItem.Analytics.title)
        Text(href)
    }
}