package ca.qc.cstj.jetbizcard.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoadingSpinner() {
    CircularProgressIndicator(
        modifier = Modifier.size(256.dp),
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 16.dp
    )
}