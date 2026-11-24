package pwr.matuszewski.harcspraw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pwr.matuszewski.harcspraw.navigation.AppNavigation
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme


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
