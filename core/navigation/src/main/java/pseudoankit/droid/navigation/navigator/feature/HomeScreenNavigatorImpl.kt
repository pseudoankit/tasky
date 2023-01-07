package pseudoankit.droid.navigation.navigator.feature

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.coreui.util.extension.toastNotImplemented
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.AgendaItemsScreenDestination
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderHomeScreenDestination

internal class HomeScreenNavigatorImpl(
    private val navController: NavController,
    private val context: Context
) : HomeScreenNavigator {

    override fun navigateToAgendaItemsScreen() {
        navController.navigate(AgendaItemsScreenDestination)
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

    override fun navigateUp() {
        // overridden in CoreNavigatorImpl
    }
}