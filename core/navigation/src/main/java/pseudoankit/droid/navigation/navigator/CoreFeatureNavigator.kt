package pseudoankit.droid.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.util.extension.clearStack
import pseudoankit.droid.coreui.util.extension.finish
import pseudoankit.droid.navigation.navigator.feature.AuthNavigatorImpl
import pseudoankit.droid.navigation.navigator.feature.HomeScreenNavigatorImpl
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator

class CoreFeatureNavigator(
    private val navController: NavController,
    private val context: Context
) : AuthNavigator by AuthNavigatorImpl(navController, context),
    HomeScreenNavigator by HomeScreenNavigatorImpl(navController, context),
    ReminderNavigator {

    override fun navigateToHomeScreen() {
        navController.navigate(HomeScreenDestination) {
            navController.clearStack(this)
        }
    }

    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }
}
