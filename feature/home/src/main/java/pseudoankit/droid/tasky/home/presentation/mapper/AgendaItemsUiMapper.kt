package pseudoankit.droid.tasky.home.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.unify.components.icon.UnifyIcons

internal object AgendaItemsUiMapper {

    val AgendaItem.label
        get() = when (this) {
            is AgendaItem.Reminder -> TextResource.NormalString("Reminder")
            is AgendaItem.Event -> TextResource.NormalString("Event")
            is AgendaItem.Task -> TextResource.NormalString("Task")
        }

    val AgendaItem.icon
        get() = when (this) {
            is AgendaItem.Reminder -> UnifyIcons.Bell
            is AgendaItem.Event -> UnifyIcons.Tasks
            is AgendaItem.Task -> UnifyIcons.Calendar
        }
}