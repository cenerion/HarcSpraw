package pwr.matuszewski.harcspraw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import pwr.matuszewski.harcspraw.navigation.AppNavigation
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme
import pwr.matuszewski.harcspraw.views.BadgeDetailsView
import pwr.matuszewski.harcspraw.views.mainscreenviews.ActiveChallengesView
import pwr.matuszewski.harcspraw.views.mainscreenviews.AllBadgesListView
import pwr.matuszewski.harcspraw.views.mainscreenviews.ObtainedBadgesListView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HarcSprawTheme {
                AppNavigation()
            }
        }
    }
}



//HarcSprawApp()
//@PreviewScreenSizes
@Composable
fun HarcSprawApp(navController: NavHostController) {

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
