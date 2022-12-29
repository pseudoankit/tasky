package pseudoankit.droid.tasky.reminder.presentation.mapper

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.tasky.reminder.domain.model.RepeatInterval
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState

internal object RepeatIntervalUiMapper {

    val RepeatInterval.label
        get() = when (this) {
            RepeatInterval.DoNotRepeat -> TextResource.NormalString("Do not repeat")
            RepeatInterval.Daily -> TextResource.NormalString("Repeats daily")
            RepeatInterval.Weekly -> TextResource.NormalString("Repeats weekly")
            RepeatInterval.Monthly -> TextResource.NormalString("Repeats monthly")
            RepeatInterval.Yearly -> TextResource.NormalString("Repeats yearly")
            RepeatInterval.Custom -> TextResource.NormalString("Custom")
        }

    val initialDialogItems: ImmutableList<ReminderUiState.State.RepeatIntervalConfig> =
        RepeatInterval.values().map {
            ReminderUiState.State.RepeatIntervalConfig(
                item = it,
                isSelected = it == RepeatInterval.DoNotRepeat
            )
        }.toImmutableList()

    val ImmutableList<ReminderUiState.State.RepeatIntervalConfig>.selectedLabel
        get() = firstOrNull {
            it.isSelected
        }?.label ?: RepeatInterval.DoNotRepeat.label
}