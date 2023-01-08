package pseudoankit.droid.tasky.home.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.unify.components.icon.UnifyIcons

internal object AgendaTypesUiMapper {

    val AgendaTypes.label
        get() = when (this) {
            is AgendaTypes.Reminder -> TextResource.NormalString("Reminder")
            is AgendaTypes.Event -> TextResource.NormalString("Event")
            is AgendaTypes.Task -> TextResource.NormalString("Task")
        }

    val AgendaTypes.icon
        get() = when (this) {
            is AgendaTypes.Reminder -> UnifyIcons.Bell
            is AgendaTypes.Event -> UnifyIcons.Tasks
            is AgendaTypes.Task -> UnifyIcons.Calendar
        }

}