package pseudoankit.droid.tasky.reminder.navigator

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

interface ReminderDeepLinkProvider {
    fun buildHomeRoute(action: AgendaTypes.Action): String
}