package pseudoankit.droid.navigation.deeplink

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.tasky.home.navigator.HomeDeepLinkProvider
import pseudoankit.droid.tasky.reminder.navigator.ActionNavTypeSerializer
import pseudoankit.droid.tasky.reminder.navigator.ReminderDeepLinkProvider

/**
 * Deeplink provider, This class will contains method to provide different screen deeplink
 * Just pass the required data and it will convert it the proper deeplink
 */
internal class DeepLinkProvider : ReminderDeepLinkProvider, HomeDeepLinkProvider {

    override fun homeScreenRoute(): String {
        return TaskyDeeplink.home
    }

    override fun reminderScreenRoute(action: AgendaTypes.Action): String {
        return TaskyDeeplink.reminder.replace(
            TaskyDeeplink.ReminderArgs.ACTION,
            ActionNavTypeSerializer.toRouteString(action)
        )
    }
}
