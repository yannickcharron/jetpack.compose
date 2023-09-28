package ca.qc.cstj.jetbizcard.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ca.qc.cstj.jetbizcard.R

@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.primary),
        shadowElevation = 4.dp, // Shadow vs Tonal to lookAt
        //color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kiwi),
            contentDescription = "",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}