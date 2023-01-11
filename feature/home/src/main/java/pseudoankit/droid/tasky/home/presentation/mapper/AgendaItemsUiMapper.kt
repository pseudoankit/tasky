package pseudoankit.droid.tasky.home.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.extension.parseToString
import pseudoankit.droid.unify.token.UnifyColors

internal object AgendaItemsUiMapper {
    val AgendaItem.Reminder.displayDateTime: String?
        get() = when (time) {
            AgendaItem.Reminder.Time.AllDay -> null
            is AgendaItem.Reminder.Time.Time -> {
                (time as? AgendaItem.Reminder.Time.Time)?.value.parseToString()
            }
        }

    val AgendaItem.backgroundColor
        get() = when (this) {
            is AgendaItem.Reminder -> UnifyColors.Green400
            is AgendaItem.Event -> UnifyColors.Blue200
            is AgendaItem.Task -> UnifyColors.Yellow300
        }

    val AgendaItem.tint get() = UnifyColors.White
}