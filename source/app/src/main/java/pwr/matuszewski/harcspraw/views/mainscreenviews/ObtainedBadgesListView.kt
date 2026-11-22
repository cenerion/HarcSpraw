package pwr.matuszewski.harcspraw.views.mainscreenviews


import androidx.annotation.DrawableRes
import androidx.collection.arraySetOf
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pwr.matuszewski.harcspraw.R
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme

@Composable
fun ObtainedBadgesListView() {
    Scaffold(Modifier.fillMaxSize()) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("Posiadane Sprawności")
            Row { Text("3 Sprawności") }
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(5.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(15) {
                    ObtainedBadgesListItem(
                        badgeName = "Nazwa Sprawności",
                        levels = arraySetOf(2,3),
                        latestDate = "20.05.2023", //TODO Change type to Date type that will be used
                        icon =  R.drawable.sim_spr_h_skaut //TODO check how icons should be included
                    )
                }
            }
        }
    }
}

@Composable
fun ObtainedBadgesListItem(
    badgeName: String,
    levels: Collection<Int>,
    latestDate: String, //TODO Change type to Date type that will be used
    @DrawableRes icon: Int //TODO check how icons should be included
) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                //TODO go to ObtainedBadgeDetailsView
            }
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp))
            .padding(8.dp),
        Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = null,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Column {
            Text(badgeName)
            Text(levels.toString())
            Text("Ostatni poziom")
            Text(latestDate)
        }
    }
}

@Preview
@Composable
fun ObtainedBadgesListViewPreview() {
    HarcSprawTheme {
        ObtainedBadgesListView()
    }
}
