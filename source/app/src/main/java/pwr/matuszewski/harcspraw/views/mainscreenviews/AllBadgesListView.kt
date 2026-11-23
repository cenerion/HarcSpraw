package pwr.matuszewski.harcspraw.views.mainscreenviews

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pwr.matuszewski.harcspraw.R
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme

@Composable
fun AllBadgesListView() {
    Scaffold(modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(15.dp))
                .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Search Bar") }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                Modifier.fillMaxSize(),
                contentPadding =  PaddingValues(horizontal = 10.dp, vertical = 0.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(40){
                    AllBadgesListItem("Nazwa", "* ** ***", R.drawable.sim_spr_h_skaut)
                }
            }
        }
    }
}

@Composable
fun AllBadgesListItem(
    badgeName: String,
    levels: String,
    @DrawableRes icon: Int
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(15.dp))
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp))
            .clickable() {
                //TODO go to BadgeDetailsView
            }
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Icon(
            painter = painterResource(id = icon),
            tint = null,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(badgeName, fontWeight = FontWeight.Bold)
        Text(levels)
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff,
    device = "spec:width=1080px,height=1080px,dpi=440"
)
@Composable
fun AllBadgesListItemPreview() {
    HarcSprawTheme() {
        AllBadgesListItem("Nazwa", "* ** ***", R.drawable.sim_spr_h_skaut)
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun AllBadgesListViewPreview() {
    HarcSprawTheme {
        AllBadgesListView()
    }
}
