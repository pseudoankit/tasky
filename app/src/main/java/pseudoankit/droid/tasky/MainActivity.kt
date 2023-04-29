package pseudoankit.droid.tasky

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.permission_manager.taskyStatus
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.permissions.rememberPermissionState
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.coreui.deeplink.navigateViaDeepLink
import pseudoankit.droid.coreui.util.extension.clearStack
import pseudoankit.droid.navigation.navgraph.mainNavGraph
import pseudoankit.droid.navigation.navigator.CoreFeatureNavigator
import pseudoankit.droid.preferencesmanager.PreferenceRepository
import pseudoankit.droid.tasky.ui.SplashScreen
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTheme

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
internal class MainActivity : ComponentActivity() {

    private val preferenceRepository: PreferenceRepository by inject()
    private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TaskyLogger.info(intent.data.toString())

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setContent {
            UnifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = UnifyColors.White
                ) {
                    var hasSplashScreenBeenDisplayed by rememberSaveable(Unit) {
                        mutableStateOf(false)
                    }

                    SplashScreen(onSplashScreenDisplayFinished = {
                        hasSplashScreenBeenDisplayed = true
                    })

                    if (hasSplashScreenBeenDisplayed) {
                        HandlePermissions()
                        InitializeNavigation()
                        ObserveLoginStatus()
                    }
                }
            }
        }
    }

    @Composable
    private fun InitializeNavigation() {
        val context = LocalContext.current

        val engine = rememberAnimatedNavHostEngine()
        navController = engine.rememberNavController()

        val isUserLoggedIn = runBlocking { preferenceRepository.isLoggedIn().firstOrNull() }

        DestinationsNavHost(
            navGraph = mainNavGraph(isUserLoggedIn = isUserLoggedIn ?: true),
            navController = navController!!,
            engine = engine,
            dependenciesContainerBuilder = {
                dependency(CoreFeatureNavigator(navController, context))
            }
        )
    }

    @Composable
    private fun ObserveLoginStatus() {
        val isLoggedIn by preferenceRepository.isLoggedIn().collectAsState(initial = true)

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
