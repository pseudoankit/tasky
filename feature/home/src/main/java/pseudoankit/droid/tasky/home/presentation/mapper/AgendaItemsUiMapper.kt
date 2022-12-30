package pseudoankit.droid.tasky.home.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.datetime.DateUtils.toString
import pseudoankit.droid.core.util.datetime.TimeUtils.parseToString
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.token.UnifyColors

internal object AgendaItemsUiMapper {

    val AgendaItem.displayDateTime
        get() = buildString {
            append(date.toString("dd MMM"))
            append(", ")
            append(time.parseToString())
        }

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

    val AgendaItem.backgroundColor
        get() = when (this) {
            is AgendaItem.Reminder -> UnifyColors.Green400
            is AgendaItem.Event -> UnifyColors.Blue200
            is AgendaItem.Task -> UnifyColors.Yellow300
        }

    val AgendaItem.tint get() = UnifyColors.White
}