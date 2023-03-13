package pseudoankit.droid.tasky

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.permission_manager.taskyStatus
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.permissions.rememberPermissionState
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import org.koin.android.ext.android.get
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.coreui.deeplink.navigateViaDeepLink
import pseudoankit.droid.coreui.util.extension.clearStack
import pseudoankit.droid.navigation.navgraph.MainNavGraph
import pseudoankit.droid.navigation.navigator.CoreFeatureNavigator
import pseudoankit.droid.preferencesmanager.PreferenceRepository
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTheme

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
internal class MainActivity : ComponentActivity() {

    private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TaskyLogger.info(intent.data.toString())

        setContent {
            HandlePermissions()
            UnifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = UnifyColors.White
                ) {
                    InitializeNavigation()
                    ObserveLoginStatus()
                }
            }
        }
    }

    @Composable
    private fun InitializeNavigation() {
        val context = LocalContext.current

        val engine = rememberAnimatedNavHostEngine()
        navController = engine.rememberNavController()

        DestinationsNavHost(
            navGraph = MainNavGraph,
            navController = navController!!,
            engine = engine,
            dependenciesContainerBuilder = {
                dependency(CoreFeatureNavigator(navController, context))
            }
        )
    }

    @Composable
    private fun ObserveLoginStatus() {
        val preferenceRepository = get<PreferenceRepository>()
        val isLoggedIn by preferenceRepository.isLoggedIn().collectAsState(initial = false)

        if (isLoggedIn.not()) {
            navController?.apply {
                clearStack()
                navigateViaDeepLink(TaskyDeeplink.login)
            }
        }
    }

    @Composable
    private fun HandlePermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return

        val launcher = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

        TaskyLogger.info("Notification Permission Status", launcher.taskyStatus.name)

        LaunchedEffect(key1 = Unit) {
            launcher.launchPermissionRequest()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController?.navigateViaDeepLink(intent?.data.toString())
    }
}
