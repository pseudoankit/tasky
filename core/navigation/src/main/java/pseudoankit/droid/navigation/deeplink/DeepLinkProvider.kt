package pseudoankit.droid.navigation.deeplink

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.tasky.home.navigator.HomeDeepLinkProvider
import pseudoankit.droid.tasky.reminder.navigator.ReminderDeepLinkProvider
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderHomeScreenDestination

internal class DeepLinkProvider : ReminderDeepLinkProvider, HomeDeepLinkProvider {

    override fun buildHomeRoute(action: AgendaTypes.Action): String {
        return ReminderHomeScreenDestination(action).route
    }
}