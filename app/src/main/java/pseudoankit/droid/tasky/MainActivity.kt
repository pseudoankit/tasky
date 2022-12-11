package pseudoankit.droid.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import pseudoankit.droid.coreui.util.TaskyColor
import pseudoankit.droid.coreui.util.TaskyTheme
import pseudoankit.droid.tasky.navigation.MainScreenNavigator
import pseudoankit.droid.tasky.navigation.util.constant.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = TaskyColor.White
                ) {
                    val navController = rememberNavController()
                    MainScreenNavigator(
                        startDestination = Routes.Login,
                        navController = navController
                    )
                }
            }
        }
    }
}
