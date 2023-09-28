package ca.qc.cstj.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.qc.cstj.jetbizcard.ui.composables.ProfilePicture
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
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
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
    val portfolioClickedState = remember {
        mutableStateOf(false)
    }
    Column(modifier =
        Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Yannick Charron",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary)
            Text(text= "Android Compose Programmer", modifier = Modifier.padding(3.dp))
            Text(text= "@yellowkiwi", modifier = Modifier.padding(3.dp), style = MaterialTheme.typography.labelSmall)

            Button(onClick = {
                //Toast.makeText(context, "Bonjour d'un bouton Compose", Toast.LENGTH_LONG).show()
                portfolioClickedState.value = !portfolioClickedState.value
            }) {
                Text(text = stringResource(R.string.portfolio), style = MaterialTheme.typography.labelMedium)
            }
            if(portfolioClickedState.value) {
                PorfoliosList()
            } 
    }
}

@Composable
private fun PorfoliosList() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)) {
            Surface(modifier = Modifier
                .padding(3.dp)
                .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                border = BorderStroke(width = 2.dp, color = Color.LightGray)
            ) {
                Portfolio(projects = listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5"))
            }
    }
}

@Composable
fun Portfolio(projects: List<String>) {
    LazyColumn {
        items(projects) { project ->
            PortfolioCardItem(project)
        }
    }
}
@Composable
private fun PortfolioCardItem(projectTitle : String) {
    Card(modifier = Modifier
        .padding(8.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)) {
            ProfilePicture(modifier = Modifier.size(100.dp))
            Column(modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterVertically),
            ) {
                Text(text =  projectTitle, fontWeight = FontWeight.Bold)
                Text(text = "Description du projet", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}