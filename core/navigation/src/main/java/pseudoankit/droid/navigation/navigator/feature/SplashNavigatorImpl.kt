package pseudoankit.droid.navigation.navigator.feature

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.splash.navigator.SplashNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination

internal class SplashNavigatorImpl(
    private val navController: NavController
) : SplashNavigator {

    override fun performNavigation(isUserLoggedIn: Boolean) {
        navController.backQueue.clear()
        navController.navigate(
            if (isUserLoggedIn) HomeScreenDestination else LoginScreenDestination
        )
    }
}