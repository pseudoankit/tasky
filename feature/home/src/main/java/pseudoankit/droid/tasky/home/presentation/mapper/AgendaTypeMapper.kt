package pseudoankit.droid.tasky.home.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaType
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.unify.components.icon.UnifyIcons

internal object AgendaTypeMapper {

    val AgendaType.label
        get() = when (this) {
            AgendaType.Reminder -> TextResource.NormalString(AgendaType.Reminder.name)
            AgendaType.Task -> TextResource.NormalString(AgendaType.Task.name)
            AgendaType.Event -> TextResource.NormalString(AgendaType.Event.name)
        }

    val AgendaType.icon
        get() = when (this) {
            AgendaType.Reminder -> UnifyIcons.Bell
            AgendaType.Task -> UnifyIcons.Tasks
            AgendaType.Event -> UnifyIcons.Calendar
        }
}