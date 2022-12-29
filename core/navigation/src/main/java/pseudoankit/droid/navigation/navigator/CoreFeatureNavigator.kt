package pseudoankit.droid.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.coreui.util.extension.finish
import pseudoankit.droid.navigation.navigator.feature.AgendaItemsScreenNavigatorImpl
import pseudoankit.droid.navigation.navigator.feature.AuthNavigatorImpl
import pseudoankit.droid.navigation.navigator.feature.HomeScreenNavigatorImpl
import pseudoankit.droid.tasky.home.navigator.AgendaItemsScreenNavigator
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator

class CoreFeatureNavigator(
    private val navController: NavController,
    private val context: Context
) : CoreNavigator,
    AuthNavigator by AuthNavigatorImpl(navController, context),
    HomeScreenNavigator by HomeScreenNavigatorImpl(navController, context),
    ReminderNavigator,
    AgendaItemsScreenNavigator by AgendaItemsScreenNavigatorImpl(navController, context) {

    override fun navigateToHomeScreen() {
        navController.backQueue.clear()
        navController.navigate(HomeScreenDestination)
    }

    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }

    override fun showBackButton(): Boolean {
        return navController.backQueue.count() > 2
    }
}