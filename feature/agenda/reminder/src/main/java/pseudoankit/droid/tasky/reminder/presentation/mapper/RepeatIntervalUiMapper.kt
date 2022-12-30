package pseudoankit.droid.tasky.reminder.presentation.mapper

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState

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

    val initialDialogItems: ImmutableList<ReminderUiState.State.RepeatIntervalConfig> =
        AgendaItem.Reminder.RepeatInterval.values().map {
            ReminderUiState.State.RepeatIntervalConfig(
                item = it,
                isSelected = it == AgendaItem.Reminder.RepeatInterval.DoNotRepeat
            )
        }.toImmutableList()

    val ImmutableList<ReminderUiState.State.RepeatIntervalConfig>.selectedLabel
        get() = firstOrNull {
            it.isSelected
        }?.label ?: AgendaItem.Reminder.RepeatInterval.DoNotRepeat.label
}