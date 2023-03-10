package pseudoankit.droid.tasky.reminder.navigator

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

interface ReminderDeepLinkProvider {
    fun reminderScreenRoute(action: AgendaTypes.Action): String
    fun homeScreenRoute(): String
}