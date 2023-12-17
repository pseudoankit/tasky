package pseudoankit.droid.navigation.deeplink

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.app_widgets.util.WidgetDeeplinkProvider
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.tasky.home.navigator.HomeDeepLinkProvider
import pseudoankit.droid.tasky.reminder.navigator.ActionNavTypeSerializer
import pseudoankit.droid.tasky.reminder.navigator.ReminderDeepLinkProvider

/**
 * Deeplink provider, This class will contains method to provide different screen deeplink
 * Just pass the required data and it will convert it the proper deeplink
 */
internal class DeepLinkProvider : ReminderDeepLinkProvider, HomeDeepLinkProvider,
    WidgetDeeplinkProvider {

    override fun agendaDetailRoute(action: AgendaTypes): String = when (action) {
        is AgendaTypes.Event -> TODO()
        is AgendaTypes.Reminder -> reminderScreenRoute(action.action)
        is AgendaTypes.Task -> TODO()
    }

    override fun homeScreenRoute(): String {
        return TaskyDeeplink.home
    }

    override fun reminderScreenRoute(action: AgendaTypes.Action): String {
        return TaskyDeeplink.reminder.replace(
            TaskyDeeplink.Path.Reminder.action,
            ActionNavTypeSerializer.toRouteString(action)
        )
    }
}
