package pseudoankit.droid.tasky.reminder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.agendamanger.domain.usecase.reminder.SaveReminderUseCase
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.util.extension.launch
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.safeLaunch
import pseudoankit.droid.coreui.util.extension.setState
import pseudoankit.droid.tasky.reminder.navigator.ReminderDeepLinkProvider
import pseudoankit.droid.tasky.reminder.presentation.mapper.ReminderMapper.mapToReminderObj
import pseudoankit.droid.tasky.reminder.presentation.mapper.ReminderMapper.mapToUiState
import java.time.LocalDate
import java.time.LocalTime

internal class ReminderViewModel(
    private val saveReminderUseCase: SaveReminderUseCase,
    private val reminderRepository: ReminderRepository,
    private val deepLinkProvider: ReminderDeepLinkProvider
) : ViewModel(),
    ContainerHost<ReminderUiState.State, ReminderUiState.SideEffect> {

    override val container: Container<ReminderUiState.State, ReminderUiState.SideEffect> =
        viewModelScope.container(ReminderUiState.State())

    private fun loadDataForId(id: Long) = safeLaunch {
        val reminder = reminderRepository.getReminder(id)
        setState { reminder.mapToUiState }
    }

    fun onInit(action: AgendaTypes.Action) = when (action) {
        AgendaTypes.Action.Create -> {}
        is AgendaTypes.Action.Edit -> loadDataForId(action.id)
    }

    fun onTextFieldValueChanged(value: String) = setState { copy(reminderText = value) }
    fun onRemindAllDayToggled() = setState {
        copy(remindAllDay = remindAllDay.not())
    }

    fun onDateValueChanged(date: LocalDate) = setState {
        copy(selectedDate = TaskyDate(date))
    }

    fun onTimeValueChanged(time: LocalTime) = setState { copy(_selectedTime = TaskyTime(time)) }
    fun toggleRepeatIntervalSelectionViewVisibility() =
        postSideEffect { ReminderUiState.SideEffect.ToggleRepeatIntervalSelectionView }


    fun onNavigateUp() = postSideEffect { ReminderUiState.SideEffect.NavigateUp }

    fun onTimeClicked() = postSideEffect { ReminderUiState.SideEffect.ShowTimePicker }
    fun onDateClicked() = postSideEffect { ReminderUiState.SideEffect.ShowDatePicker }


    fun onSave() = launch {
        if (state.reminderText.isEmpty()) {
            postSideEffect(ReminderUiState.SideEffect.NavigateToHomeScreen)
            return@launch
        }

        val payload = state.mapToReminderObj
        val alarmDeepLink = deepLinkProvider.reminderScreenRoute(AgendaTypes.Action.Edit(payload.id))

        when (saveReminderUseCase.invoke(payload = payload, alarmDeepLink = alarmDeepLink)) {
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
            copy(selectedRepeatInterval = selectedInterval)
        }
        toggleRepeatIntervalSelectionViewVisibility()
    }
}
