package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.coreui.surface.TaskyDestinationSurfaceConfig
import pseudoankit.droid.coreui.util.extension.showToast
import pseudoankit.droid.coreui.util.extension.state
import pseudoankit.droid.coreui.util.extension.toastNotImplemented
import pseudoankit.droid.tasky.reminder.di.ReminderModule
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel
import pseudoankit.droid.tasky.reminder.presentation.mapper.RepeatIntervalUiMapper.label
import pseudoankit.droid.unify.components.dialog.UnifyDialog
import pseudoankit.droid.unify.components.dialog.datepicker.UnifyDatePicker
import pseudoankit.droid.unify.components.dialog.timepicker.UnifyTimePicker
import pseudoankit.droid.unify.components.divider.UnifyDivider
import java.time.LocalTime

@Destination
@Composable
internal fun ReminderHomeScreen(
    navigator: ReminderNavigator,
    action: AgendaTypes.Action
) = ReminderModule.load {
    val viewModel = getViewModel<ReminderViewModel>()
    HandleSideEffect(viewModel, navigator = navigator)

    TaskyDestinationSurface(
        config = TaskyDestinationSurfaceConfig(
            topBar = ReminderHomeScreenComponents.topBarConfig(
                onNavigateUp = viewModel::onNavigateUp,
                onSave = viewModel::onSave
            ),
        ),
        padding = PaddingValues(),
        singleEvents = {
            viewModel.onInit(action)
        }
    ) {
        val state = viewModel.collectAsState().value

        ReminderHomeScreenComponents.TextField(
            value = state.reminderText,
            onReminderTextFieldValueChanged = viewModel::onTextFieldValueChanged
        )
        UnifyDivider()
        ReminderHomeScreenComponents.ReminderConfigurations(
            remindAllDay = state.remindAllDay,
            onRemindAllDayToggled = viewModel::onRemindAllDayToggled,
            date = state.displayDate,
            time = state.displayTime,
            onDateClicked = viewModel::onDateClicked,
            onTimeClicked = viewModel::onTimeClicked
        )
        UnifyDivider()
        ReminderHomeScreenComponents.RepeatsReminderAtText(
            repeatIntervalLabel = state.selectedRepeatInterval.label,
            onClick = viewModel::toggleRepeatIntervalSelectionViewVisibility
        )
        UnifyDivider()
    }
}

@Composable
private fun HandleSideEffect(
    viewModel: ReminderViewModel = getViewModel(),
    navigator: ReminderNavigator
) {
    val datePicker = UnifyDatePicker(
        config = UnifyDatePicker.Config(
            initialDate = viewModel.state.selectedDate.value,
            onDateChanged = viewModel::onDateValueChanged
        )
    )

    val timePicker = UnifyTimePicker(
        config = UnifyTimePicker.Config(
            initialTime = viewModel.state.selectedTime?.value ?: LocalTime.now(),
            onTimeChanged = viewModel::onTimeValueChanged
        )
    )

    val repeatsOnDialog = UnifyDialog(showActionButton = false) {
        ReminderHomeScreenComponents.RepeatIntervalDialogItems(
            items = viewModel.state.repeatIntervalItems,
            onClick = viewModel::onRepeatIntervalChanged,
            selectedItem = viewModel.state.selectedRepeatInterval
        )
    }

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.container.sideEffectFlow.collectLatest {
            when (it) {
                ReminderUiState.SideEffect.NavigateUp -> navigator.navigateUp()
                ReminderUiState.SideEffect.ShowDatePicker -> datePicker.show()
                ReminderUiState.SideEffect.ShowTimePicker -> timePicker.show()
                ReminderUiState.SideEffect.ToggleRepeatIntervalSelectionView -> repeatsOnDialog.toggle()
                ReminderUiState.SideEffect.ShowCustomRepeatIntervalSelector -> context.toastNotImplemented()
                ReminderUiState.SideEffect.NavigateToHomeScreen -> navigator.navigateToHomeScreen()
                is ReminderUiState.SideEffect.ShowError -> context.showToast(it.message)
            }
        }
    }
}
