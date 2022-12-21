package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.surface.HandleKoinModuleInit
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.tasky.reminder.di.ReminderModule
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.components.topbar.UnifyTopBar

@Destination
@Composable
internal fun ReminderHomeScreen() = HandleKoinModuleInit(module = ReminderModule) {
    val viewModel = getViewModel<ReminderViewModel>()

    TaskyDestinationSurface(
        topBarConfig = UnifyTopBar.Config(
            leadingIcon = UnifyIcon.Config(
                icon = UnifyIcons.Cross,
                onClick = viewModel::onNavigateUp
            ),
            trailingSection = UnifyTopBar.TrailingSection(
                text = UnifyTextView.Config(
                    text = "Save"
                ),
                icon = UnifyIcon.Config(icon = UnifyIcons.CheckCircle),
                onClick = viewModel::onSave
            )
        )
    ) {

    }
}