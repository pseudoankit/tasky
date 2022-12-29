package pseudoankit.droid.tasky.reminder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.core.util.datetime.model.TaskyTime
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.setState
import java.time.LocalDate
import java.time.LocalTime

internal class ReminderViewModel : ViewModel(),
    ContainerHost<ReminderUiState.State, ReminderUiState.SideEffect> {

    override val container: Container<ReminderUiState.State, ReminderUiState.SideEffect> =
        viewModelScope.container(ReminderUiState.State())

    fun onTextFieldValueChanged(value: String) = setState { copy(reminderText = value) }
    fun onRemindAllDayToggled() = setState { copy(remindAllDay = remindAllDay.not()) }
    fun onDateValueChanged(date: LocalDate) = setState {
        copy(selectedDate = selectedDate.copy(date))
    }

    fun onTimeValueChanged(time: LocalTime) = setState { copy(_selectedTime = TaskyTime(time)) }


    fun onRepeatsOnLabelClicked() {}
    fun onNavigateUp() = postSideEffect { ReminderUiState.SideEffect.OnNavigateUp }
    fun onTimeClicked() = postSideEffect { ReminderUiState.SideEffect.ShowTimePicker }
    fun onDateClicked() = postSideEffect { ReminderUiState.SideEffect.ShowDatePicker }


    fun onSave() {}
}