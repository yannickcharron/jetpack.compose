package ca.qc.cstj.navigationdemo.ui.screens.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListScreen(viewModel: ListViewModel = viewModel()) {
    val counter by remember { mutableStateOf(0) }

    //https://stackoverflow.com/questions/76808167/this-function-is-called-multiple-times-in-jetpack-compose
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    Log.d("ListScreen", counter.toString())
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = state.value.counter.toString(), fontSize = 18.sp)
        Button(onClick = { viewModel.random() }) {
            Text(text = "Random", fontSize = 18.sp)
        }
    }
}