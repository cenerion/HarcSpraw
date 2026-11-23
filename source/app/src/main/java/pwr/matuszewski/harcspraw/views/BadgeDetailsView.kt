package pwr.matuszewski.harcspraw.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pwr.matuszewski.harcspraw.R
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme

@Composable
fun BadgeDetailsView(navController: NavHostController) {
    Scaffold(
        Modifier.fillMaxSize()
    ) { innerPadding ->
        Surface {
            Column(
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Sprawność harcerska")
                Row(
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sim_spr_h_skaut),
                        tint = null,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                    Column() {
                        Text("Nazwa sprawności",
                            fontWeight = FontWeight(900),
                            fontSize = 30.sp
                        )
                        Text("Kategoria: ??")
                    }
                }
                Column(
                    Modifier.padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text("Poziom sprawności",
                        fontWeight = FontWeight(800)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("*")
                        Text("**")
                        Text("***")
                        Text("****")
                    }
                    Text("Możesz zacząć od dowolnego poziomu.")
                }

                Text("Opis sprawności",
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                Text("Zadania (ile)")
                LazyColumn(modifier = Modifier.weight(1.0f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(5) {
                        Card(
                            border = BorderStroke(1.dp, Color.Gray)
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text("$it")
                                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ex elit, porttitor in placerat a, pretium vitae mi. Curabitur et massa tempus, scelerisque lectus ac, scelerisque mauris. Vestibulum quis lacinia risus. Curabitur eget consequat est, id porta arcu.")
                            }
                        }
                    }
                }
                Button(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    onClick = {}
                ) {
                    Text("Rozpocznij próbę")
                }
            }
        }
    }
}

@Preview
@Composable
fun BadgeDetailsViewPreview() {
    HarcSprawTheme {
        BadgeDetailsView(rememberNavController())
    }
}
