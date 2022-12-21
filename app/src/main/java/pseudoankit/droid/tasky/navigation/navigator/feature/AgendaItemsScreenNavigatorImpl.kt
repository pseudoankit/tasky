package pseudoankit.droid.tasky.navigation.navigator.feature

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.coreui.util.extension.toastNotImplemented
import pseudoankit.droid.tasky.home.navigator.AgendaItemsScreenNavigator
import pseudoankit.droid.tasky.navigation.navigator.CoreNavigatorImpl
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderHomeScreenDestination

internal class AgendaItemsScreenNavigatorImpl(
    private val navController: NavController,
    private val context: Context
) : AgendaItemsScreenNavigator, CoreNavigator by CoreNavigatorImpl(navController, context) {
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