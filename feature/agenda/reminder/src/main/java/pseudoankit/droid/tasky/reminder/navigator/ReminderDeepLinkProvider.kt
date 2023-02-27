package pseudoankit.droid.tasky.reminder.navigator

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

interface ReminderDeepLinkProvider {
    fun agendaRoute(action: AgendaTypes.Action): String
    fun homeRoute(): String
}