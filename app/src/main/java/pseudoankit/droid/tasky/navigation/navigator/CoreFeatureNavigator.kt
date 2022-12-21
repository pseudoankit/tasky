package pseudoankit.droid.tasky.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.authentication.presentation.destinations.RegistrationScreenDestination
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.coreui.util.extension.finish
import pseudoankit.droid.coreui.util.extension.toastNotImplemented
import pseudoankit.droid.tasky.home.navigator.AgendaItemsScreenNavigator
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.AgendaItemsScreenDestination
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderHomeScreenDestination

// todo change to delegate
class CoreFeatureNavigator(
    private val navController: NavController,
    private val context: Context
) : AuthNavigator, HomeScreenNavigator, AgendaItemsScreenNavigator, CoreNavigator {
    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }

    override fun showBackButton(): Boolean {
        return navController.backQueue.count() > 2
    }

    override fun navigateToRegistrationScreen() {
        navController.navigate(RegistrationScreenDestination)
    }

    override fun isAgendaItemsScreenVisible(): Boolean {
        // TODO
        return false
    }

    override fun navigateToAgendaItemsScreen() {
        navController.navigate(AgendaItemsScreenDestination)
    }

    override fun navigateToHome() {
        navController.navigate(HomeScreenDestination)
    }

    override fun navigateToReminder() {
        navController.navigate(ReminderHomeScreenDestination)
    }

    override fun navigateToTasks() {
        context.toastNotImplemented()
    }

    override fun navigateToEvents() {
        context.toastNotImplemented()
    }
}