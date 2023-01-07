package pseudoankit.droid.tasky.reminder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toImmutableList
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.setState
import pseudoankit.droid.tasky.reminder.domain.usecase.SaveReminderUseCase
import java.time.LocalDate
import java.time.LocalTime

internal class ReminderViewModel(
    private val saveReminderUseCase: SaveReminderUseCase
) : ViewModel(),
    ContainerHost<ReminderUiState.State, ReminderUiState.SideEffect> {

    override val container: Container<ReminderUiState.State, ReminderUiState.SideEffect> =
        viewModelScope.container(ReminderUiState.State())

    fun onTextFieldValueChanged(value: String) = setState { copy(reminderText = value) }
    fun onRemindAllDayToggled() = setState { copy(remindAllDay = remindAllDay.not()) }
    fun onDateValueChanged(date: LocalDate) = setState {
        copy(selectedDate = TaskyDate(date))
    }

    fun onTimeValueChanged(time: LocalTime) = setState { copy(_selectedTime = TaskyTime(time)) }
    fun toggleRepeatIntervalSelectionViewVisibility() =
        postSideEffect { ReminderUiState.SideEffect.ToggleRepeatIntervalSelectionView }


    fun onNavigateUp() = postSideEffect { ReminderUiState.SideEffect.NavigateUp }

    fun onTimeClicked() = postSideEffect { ReminderUiState.SideEffect.ShowTimePicker }
    fun onDateClicked() = postSideEffect { ReminderUiState.SideEffect.ShowDatePicker }


    fun onSave() = intent {
        when (val result = saveReminderUseCase.invoke(state)) {
            is TaskyResult.Error -> postSideEffect(
                ReminderUiState.SideEffect.ShowError(
                    TextResource.NormalString("Failed to save reminder! Please try again")
                )
            )
            is TaskyResult.Success -> postSideEffect(ReminderUiState.SideEffect.NavigateToHomeScreen)
        }
    }

    fun onRepeatIntervalChanged(selectedInterval: AgendaItem.Reminder.RepeatInterval) {
        if (selectedInterval == AgendaItem.Reminder.RepeatInterval.Custom) {
            postSideEffect { ReminderUiState.SideEffect.ShowCustomRepeatIntervalSelector }
            toggleRepeatIntervalSelectionViewVisibility()
            return
        }

        setState {
            copy(repeatIntervalItems = repeatIntervalItems.map { item ->
                item.copy(isSelected = item.item == selectedInterval)
            }.toImmutableList())
        }
        toggleRepeatIntervalSelectionViewVisibility()
    }
}