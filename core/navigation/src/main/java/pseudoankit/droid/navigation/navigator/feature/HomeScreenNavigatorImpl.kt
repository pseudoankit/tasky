package pseudoankit.droid.navigation.navigator.feature

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.coreui.util.extension.toastNotImplemented
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.AgendaItemsScreenDestination
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderScreenDestination

internal class HomeScreenNavigatorImpl(
    private val navController: NavController,
    private val context: Context
) : HomeScreenNavigator {

    override fun navigateToAgendaItemsSelectorScreen() {
        navController.navigate(AgendaItemsScreenDestination)
    }

    override fun navigateToAgendaScreen(agendaTypes: AgendaTypes) {
        when (agendaTypes) {
            is AgendaTypes.Reminder -> navController.navigate(
                ReminderScreenDestination(agendaTypes.action)
            )
            is AgendaTypes.Event -> context.toastNotImplemented()
            is AgendaTypes.Task -> context.toastNotImplemented()
        }
    }

    override fun navigateUp() {
        // overridden in CoreNavigatorImpl
    }
}