package pwr.matuszewski.harcspraw.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import pwr.matuszewski.harcspraw.views.BadgeDetailsView
import pwr.matuszewski.harcspraw.views.MainScreen
import pwr.matuszewski.harcspraw.views.ObtainedBadgeDetailsView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreen
    ) {
        composable<MainScreen> { MainScreen(navController)}
        composable<BadgeDetails> {BadgeDetailsView(navController)}
        composable<ObtainedBadgeDetails> { ObtainedBadgeDetailsView() }
    }
}


@Serializable
object MainScreen
@Serializable
object BadgeDetails

@Serializable
object ObtainedBadgeDetails
