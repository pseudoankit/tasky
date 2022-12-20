package pseudoankit.droid.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import pseudoankit.droid.tasky.navigation.navgraph.MainNavGraph
import pseudoankit.droid.tasky.navigation.navigator.CoreFeatureNavigator
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = UnifyColors.White
                ) {
                    val context = LocalContext.current
                    val navController = rememberNavController()

                    DestinationsNavHost(
                        navGraph = MainNavGraph,
                        navController = navController,
                        dependenciesContainerBuilder = {
                            dependency(CoreFeatureNavigator(navController, context))
                        }
                    )
                }
            }
        }
    }
}
