package pseudoankit.droid.navigation.navigator.feature

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.splash.navigator.SplashNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.navigation.popUpTo
import pseudoankit.droid.coreui.util.extension.clearStack

internal class SplashNavigatorImpl(
    private val navController: NavController
) : SplashNavigator {

    override fun performNavigation(isUserLoggedIn: Boolean) {
        val destination = if (isUserLoggedIn) HomeScreenDestination else LoginScreenDestination
        navController.navigate(destination) {
            navController.clearStack(this)
        }
    }
}