package ca.qc.cstj.jetbizcard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.qc.cstj.jetbizcard.ui.theme.JetBizCardTheme
import ca.qc.cstj.jetbizcard.ui.theme.OffWhite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
private fun CreateBizCard() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(modifier = Modifier.fillMaxSize().padding(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = OffWhite)
        ) {
            Column(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicture()
                Divider(modifier = Modifier
                    .width(200.dp)
                    .padding(0.dp, 10.dp),
                        color = MaterialTheme.colorScheme.primary,
                        thickness = 0.5.dp
                )
                CardInfoSection()
            }
        }
    }
}
@Composable
private fun CardInfoSection(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(modifier =
        Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Yannick Charron",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary)
            Text(text= "Android Compose Programmer", modifier = Modifier.padding(3.dp))
            Text(text= "@yellowkiwi", modifier = Modifier.padding(3.dp), style = MaterialTheme.typography.labelSmall)

            Button(onClick = {
                Toast.makeText(context, "Bonjour d'un bouton Compose", Toast.LENGTH_LONG).show()
            }) {
                Text(text = stringResource(R.string.portfolio), style = MaterialTheme.typography.labelMedium)
            }
    }
}

@Preview
@Composable
private fun Content() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)) {
            Surface(modifier = Modifier
                .padding(3.dp)
                .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                border = BorderStroke(width = 2.dp, color = Color.LightGray)
            ) {
                Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
            }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    Text(text= "Portfolio Here")
}

@Composable
private fun ProfilePicture(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
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
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}