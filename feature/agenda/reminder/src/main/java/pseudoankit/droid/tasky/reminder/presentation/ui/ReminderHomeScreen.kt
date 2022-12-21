package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.surface.HandleKoinModuleInit
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.tasky.reminder.di.ReminderModule
import pseudoankit.droid.tasky.reminder.navigator.ReminderNavigator
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.components.topbar.UnifyTopBar

@Destination
@Composable
internal fun ReminderHomeScreen(
    navigator: ReminderNavigator
) = HandleKoinModuleInit(module = ReminderModule) {
    val viewModel = getViewModel<ReminderViewModel>()
    HandleSideEffect(viewModel, navigator = navigator)

    TaskyDestinationSurface(
        topBarConfig = topBarConfig(
            onNavigateUp = viewModel::onNavigateUp,
            onSave = viewModel::onSave
        ),
    ) {
        val state = viewModel.state

        UnifyTextField(
            config = UnifyTextField.Config(
                placeholder = "Remind me to...",
                value = state.reminderText,
                onValueChange = viewModel::onReminderTextFieldValueChanged
            )
        )
    }
}

@Composable
private fun HandleSideEffect(
    viewModel: ReminderViewModel = getViewModel(),
    navigator: ReminderNavigator
) {
    LaunchedEffect(Unit) {
        viewModel.sideEffect.collectLatest {
            when (it) {
                ReminderUiState.SideEffect.OnNavigateUp -> navigator.navigateUp()
                ReminderUiState.SideEffect.ShowDatePicker -> TODO()
            }
        }
    }
}

private fun topBarConfig(
    onNavigateUp: () -> Unit,
    onSave: () -> Unit,
) = UnifyTopBar.Config(
    leadingIcon = UnifyIcon.Config(
        icon = UnifyIcons.Cross,
        onClick = onNavigateUp
    ),
    trailingSection = UnifyTopBar.TrailingSection(
        text = UnifyTextView.Config(
            text = "Save"
        ),
        icon = UnifyIcon.Config(icon = UnifyIcons.CheckCircle),
        onClick = onSave
    )
)