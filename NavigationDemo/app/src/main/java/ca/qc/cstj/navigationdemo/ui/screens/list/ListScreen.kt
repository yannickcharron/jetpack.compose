package ca.qc.cstj.navigationdemo.ui.screens.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ca.qc.cstj.navigationdemo.ui.components.BottomNavItem
import androidx.lifecycle.viewmodel.compose.viewModel

//https://foso.github.io/Jetpack-Compose-Playground/
@Composable
fun ListScreen(viewModel: ListViewModel = viewModel()) {
    val counter by remember { mutableIntStateOf(0) }

    //https://stackoverflow.com/questions/76808167/this-function-is-called-multiple-times-in-jetpack-compose
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    Log.d("ListScreen", "Recomposition")

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = state.value.counter.toString(), fontSize = 18.sp)
        Button(onClick = { viewModel.random() }) {
            Text(text = "Random", fontSize = 18.sp)
        }
        Grid(state.value.list)

    }


    
}

@Composable
fun Vertical(elements: List<Int>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = elements) { item ->
            Card(item.toString())
        }
    }
}

@Composable
fun Horizontal(elements: List<Int>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(items = elements) { item ->
            Card(item.toString())
        }
    }
}

@Composable
fun Grid(elements: List<Int>) {
    LazyVerticalGrid(columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(
            start = 8.dp,
            top = 8.dp,
            end = 8.dp,
            bottom = 8.dp
        )
    ) {
        items(elements.size) {
            Card(it.toString())
        }
    }
}

@Composable
fun Card(item: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        )

    ) {
        Text(text = item,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp, textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold)
    }
}

