package ca.qc.cstj.navigationdemo.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem

@Composable
fun ListScreen() {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(8.dp)
        .background(Color.Gray)) {
        Text(BottomNavItem.List.title)
    }
}