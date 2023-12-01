package ca.qc.cstj.navigationdemo.ui.screens.analytics
import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.CreationExtras
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem

@Composable
fun AnalyticsScreen(href: String,
                    viewModel: AnalyticsViewModel = viewModel(factory = AnalyticsViewModel.Factory(href) ) ) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val counter by remember { mutableIntStateOf(0) }

    Log.d("AnalyticsScreen", counter.toString())
    Column(modifier = Modifier.padding(8.dp)) {
        Text(BottomNavItem.Analytics.title)
        Text(uiState.value)
    }
}