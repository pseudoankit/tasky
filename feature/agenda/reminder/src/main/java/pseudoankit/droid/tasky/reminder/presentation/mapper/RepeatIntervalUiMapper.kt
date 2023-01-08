package pseudoankit.droid.tasky.reminder.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.TextResource

internal object RepeatIntervalUiMapper {

    val AgendaItem.Reminder.RepeatInterval.label
        get() = when (this) {
            AgendaItem.Reminder.RepeatInterval.DoNotRepeat -> TextResource.NormalString("Do not repeat")
            AgendaItem.Reminder.RepeatInterval.Daily -> TextResource.NormalString("Repeats daily")
            AgendaItem.Reminder.RepeatInterval.Weekly -> TextResource.NormalString("Repeats weekly")
            AgendaItem.Reminder.RepeatInterval.Monthly -> TextResource.NormalString("Repeats monthly")
            AgendaItem.Reminder.RepeatInterval.Yearly -> TextResource.NormalString("Repeats yearly")
            AgendaItem.Reminder.RepeatInterval.Custom -> TextResource.NormalString("Custom")
        }
}