package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.coreui.util.extension.showToast
import pseudoankit.droid.coreui.util.extension.state
import pseudoankit.droid.coreui.util.extension.toastNotImplemented
import pseudoankit.droid.tasky.reminder.di.ReminderModule
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel
import pseudoankit.droid.tasky.reminder.presentation.mapper.RepeatIntervalUiMapper.label
import pseudoankit.droid.unify.component.dialog.UnifyDialog
import pseudoankit.droid.unify.component.dialog.datepicker.UnifyDatePicker
import pseudoankit.droid.unify.component.dialog.datepicker.UnifyDatePickerConfig
import pseudoankit.droid.unify.component.dialog.rememberUnifyDialogState
import pseudoankit.droid.unify.component.dialog.timepicker.UnifyTimePicker
import pseudoankit.droid.unify.component.dialog.timepicker.UnifyTimePickerConfig
import pseudoankit.droid.unify.component.divider.UnifyDivider
import pseudoankit.droid.unify.screen.UnifyScreen
import pseudoankit.droid.unify.screen.UnifyScreenConfig
import java.time.LocalTime

@Destination(
    deepLinks = [
        DeepLink(uriPattern = TaskyDeeplink.reminder)
    ]
)
@Composable
internal fun ReminderScreen(
    navigator: ReminderNavigator,
    action: AgendaTypes.Action
) = ReminderModule.load {
    val viewModel = getViewModel<ReminderViewModel>()
    HandleSideEffect(navigator = navigator)

    UnifyScreen(
        config = UnifyScreenConfig(
            topBar = ReminderScreenComponents.topBarConfig(
                onNavigateUp = viewModel::onNavigateUp,
                onSave = viewModel::onSave
            ),
        ),
        singleEvents = {
            viewModel.onInit(action)
        }
    ) {
        val state = viewModel.collectAsState().value

        ReminderScreenComponents.TextField(
            value = state.reminderText,
            onReminderTextFieldValueChanged = viewModel::onTextFieldValueChanged
        )
        UnifyDivider()
        ReminderScreenComponents.ReminderConfigurations(
            remindAllDay = state.remindAllDay,
            onRemindAllDayToggled = viewModel::onRemindAllDayToggled,
            date = state.displayDate,
            time = state.displayTime,
            onDateClicked = viewModel::onDateClicked,
            onTimeClicked = viewModel::onTimeClicked
        )
        UnifyDivider()
        ReminderScreenComponents.RepeatsReminderAtText(
            repeatIntervalLabel = state.selectedRepeatInterval.label,
            onClick = viewModel::toggleRepeatIntervalSelectionViewVisibility
        )
        UnifyDivider()
    }
}

@Composable
private fun HandleSideEffect(
    navigator: ReminderNavigator,
    viewModel: ReminderViewModel = getViewModel(),
) {
    val datePickerState = rememberUnifyDialogState()
    UnifyDatePicker(
        config = UnifyDatePickerConfig(
            initialDate = viewModel.state.selectedDate.value,
        ),
        onDateChanged = viewModel::onDateValueChanged,
        datePickerState = datePickerState
    )

    val timePickerState = rememberUnifyDialogState()
    UnifyTimePicker(
        config = UnifyTimePickerConfig(
            initialTime = viewModel.state.selectedTime?.value ?: LocalTime.now(),
        ),
        onTimeChanged = viewModel::onTimeValueChanged,
        timePickerState = timePickerState
    )

    val repeatsOnDialogState = rememberUnifyDialogState()
    UnifyDialog(showActionButton = false, state = repeatsOnDialogState) {
        ReminderScreenComponents.RepeatIntervalDialogItems(
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
                ReminderUiState.SideEffect.ShowDatePicker -> datePickerState.show()
                ReminderUiState.SideEffect.ShowTimePicker -> timePickerState.show()
                ReminderUiState.SideEffect.ToggleRepeatIntervalSelectionView -> repeatsOnDialogState.toggle()
                ReminderUiState.SideEffect.ShowCustomRepeatIntervalSelector -> context.toastNotImplemented()
                ReminderUiState.SideEffect.NavigateToHomeScreen -> navigator.navigateToHomeScreen()
                is ReminderUiState.SideEffect.ShowError -> context.showToast(it.message)
            }
        }
    }
}
