package pseudoankit.droid.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import pseudoankit.droid.coreui.token.TaskyColor
import pseudoankit.droid.coreui.token.TaskyTheme
import pseudoankit.droid.tasky.navigation.navgraph.MainNavGraph

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
                    DestinationsNavHost(
                        navGraph = MainNavGraph,
                        dependenciesContainerBuilder = {
                            dependency(navController)
                        }
                    )
                }
            }
        }
    }
}
