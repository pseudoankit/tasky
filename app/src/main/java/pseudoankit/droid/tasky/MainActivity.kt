package pseudoankit.droid.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import pseudoankit.droid.navigation.navgraph.MainNavGraph
import pseudoankit.droid.navigation.navigator.CoreFeatureNavigator
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTheme

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = UnifyColors.White
                ) {
                    InitializeNavigation()
                }
            }
        }
    }

    @Composable
    private fun InitializeNavigation() {
        val context = LocalContext.current

        val engine = rememberAnimatedNavHostEngine()
        val navController = engine.rememberNavController()

        // TODO : screen transitions

        DestinationsNavHost(
            navGraph = MainNavGraph,
            navController = navController,
            engine = engine,
            dependenciesContainerBuilder = {
                dependency(CoreFeatureNavigator(navController, context))
            }
        )
    }
}
