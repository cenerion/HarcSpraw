package pwr.matuszewski.harcspraw.views

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import pwr.matuszewski.harcspraw.R
import pwr.matuszewski.harcspraw.views.mainscreenviews.ActiveChallengesView
import pwr.matuszewski.harcspraw.views.mainscreenviews.AllBadgesListView
import pwr.matuszewski.harcspraw.views.mainscreenviews.ObtainedBadgesListView


//@PreviewScreenSizes
@Composable
fun MainScreen(navController: NavHostController) {

    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        when(currentDestination) {
            AppDestinations.HOME -> AllBadgesListView(navController)
            AppDestinations.FAVORITES -> ActiveChallengesView()
            AppDestinations.PROFILE -> ObtainedBadgesListView()
            AppDestinations.TEST -> BadgeDetailsView(navController)
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Lista sprawnosci", R.drawable.ic_home),
    FAVORITES("Otwarte próby", R.drawable.ic_favorite),
    PROFILE("Posiadane", R.drawable.ic_account_box),
    TEST("Test", R.drawable.ic_account_box),
}
