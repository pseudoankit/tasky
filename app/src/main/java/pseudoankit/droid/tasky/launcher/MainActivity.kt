package pseudoankit.droid.tasky.launcher

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.permissions.rememberPermissionState
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigate
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.coreui.deeplink.navigateViaDeepLink
import pseudoankit.droid.tasky.navigation.navgraph.NavGraph
import pseudoankit.droid.tasky.navigation.navigator.CoreFeatureNavigator
import pseudoankit.droid.tasky.util.hide
import pseudoankit.droid.tasky.util.show
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTheme
import pseudoankit.droid.unify.utils.enableTestTagAsResourceId

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
internal class MainActivity : ComponentActivity() {

    private var navController: NavHostController? = null
    private val splashScreen: SplashScreen by lazy { installSplashScreen() }

    override fun onCreate(savedInstanceState: Bundle?) {
        splashScreen.show()
        super.onCreate(savedInstanceState)

        MainActivityModule.loadModules()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setContent {
            UnifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = UnifyColors.White
                ) {
                    val viewModel = getViewModel<MainActivityViewModel>()
                    val state = viewModel.collectAsState().value

                    InitializeNavigation(
                        isUserLoggedIn = state.isUserLoggedIn
                    )
                    viewModel.HandleSideEffect()
                    HideSplashScreenAfterNavigation()
                }
            }
        }
    }

    @Composable
    private fun InitializeNavigation(
        isUserLoggedIn: Boolean
    ) {
        val context = LocalContext.current

        val engine = rememberAnimatedNavHostEngine()
        navController = engine.rememberNavController()

        DestinationsNavHost(
            navGraph = NavGraph.root(isUserLoggedIn = isUserLoggedIn),
            navController = navController!!,
            engine = engine,
            dependenciesContainerBuilder = {
                dependency(CoreFeatureNavigator(navController, context))
            },
            modifier = Modifier.enableTestTagAsResourceId()
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController?.navigateViaDeepLink(intent?.data.toString())
    }

    @Composable
    private fun HideSplashScreenAfterNavigation() {
        LaunchedEffect(navController) {
            if (navController?.currentDestination != null) {
                splashScreen.hide()
            }
        }
    }

    @SuppressLint("InlinedApi")
    @Composable
    private fun MainActivityViewModel.HandleSideEffect() {
        val launcher = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

        LaunchedEffect(Unit) {
            container.sideEffectFlow.collectLatest { effect ->
                when (effect) {
                    MainActivityViewModel.SideEffect.NavigateToLoginScreen -> {
                        if (navController?.currentDestination?.route != LoginScreenDestination.route) {
                            navController?.navigate(LoginScreenDestination)
                        }
                    }

                    MainActivityViewModel.SideEffect.LaunchNotificationPermissionRequest -> {
                        launcher.launchPermissionRequest()
                    }
                }
            }
        }
    }
}
