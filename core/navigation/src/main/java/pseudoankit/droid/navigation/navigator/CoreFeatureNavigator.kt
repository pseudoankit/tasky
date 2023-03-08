package pseudoankit.droid.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.coreui.util.extension.finish
import pseudoankit.droid.navigation.navigator.feature.AuthNavigatorImpl
import pseudoankit.droid.navigation.navigator.feature.HomeScreenNavigatorImpl
import pseudoankit.droid.navigation.navigator.feature.SplashNavigatorImpl
import pseudoankit.droid.splash.navigator.SplashNavigator
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator

class CoreFeatureNavigator(
    private val navController: NavController,
    private val context: Context
) : AuthNavigator by AuthNavigatorImpl(navController, context),
    HomeScreenNavigator by HomeScreenNavigatorImpl(navController, context),
    SplashNavigator by SplashNavigatorImpl(navController),
    ReminderNavigator {

    override fun navigateToHomeScreen() {
        navController.backQueue.clear()
        navController.navigate(HomeScreenDestination)
    }

    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }
}
