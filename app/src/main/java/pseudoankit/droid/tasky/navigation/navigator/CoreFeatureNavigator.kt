package pseudoankit.droid.tasky.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.coreui.util.extension.finish
import pseudoankit.droid.tasky.home.navigator.AgendaItemsScreenNavigator
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.navigation.navigator.feature.AgendaItemsScreenNavigatorImpl
import pseudoankit.droid.tasky.navigation.navigator.feature.AuthNavigatorImpl
import pseudoankit.droid.tasky.navigation.navigator.feature.HomeScreenNavigatorImpl
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator

internal class CoreFeatureNavigator(
    private val navController: NavController,
    private val context: Context
) : CoreNavigator,
    ReminderNavigator,
    AuthNavigator by AuthNavigatorImpl(navController, context),
    HomeScreenNavigator by HomeScreenNavigatorImpl(navController, context),
    AgendaItemsScreenNavigator by AgendaItemsScreenNavigatorImpl(navController, context) {

    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }

    override fun showBackButton(): Boolean {
        return navController.backQueue.count() > 2
    }
}