package pseudoankit.droid.navigation.deeplink

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.tasky.home.navigator.HomeDeepLinkProvider
import pseudoankit.droid.tasky.reminder.navigator.ActionNavTypeSerializer
import pseudoankit.droid.tasky.reminder.navigator.ReminderDeepLinkProvider

internal class DeepLinkProvider : ReminderDeepLinkProvider, HomeDeepLinkProvider {

    override fun buildHomeRoute(action: AgendaTypes.Action): String {
        return TaskyDeeplink.Reminder.route.replace(
            TaskyDeeplink.Reminder.ARG_ACTION,
            ActionNavTypeSerializer.toRouteString(action)
        )
    }
}
