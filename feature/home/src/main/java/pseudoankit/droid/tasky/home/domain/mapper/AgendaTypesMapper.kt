package pseudoankit.droid.tasky.home.domain.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

internal object AgendaTypesMapper {

    val AgendaItem.mapToAgendaTypes
        get() = when (this) {
            is AgendaItem.Event -> AgendaTypes.Event(AgendaTypes.Action.Edit(id))
            is AgendaItem.Reminder -> AgendaTypes.Reminder(AgendaTypes.Action.Edit(id))
            is AgendaItem.Task -> AgendaTypes.Task(AgendaTypes.Action.Edit(id))
        }
}