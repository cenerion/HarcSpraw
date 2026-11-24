package pwr.matuszewski.harcspraw.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import pwr.matuszewski.harcspraw.HarcSprawApp
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme
import pwr.matuszewski.harcspraw.views.BadgeDetailsView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreen
    ) {
        composable<MainScreen> {HarcSprawApp(navController)}
        composable<BadgeDetails> {BadgeDetailsView(navController)}
    }
}


@Serializable
object MainScreen
@Serializable
object BadgeDetails
