package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.surface.HandleKoinModuleInit
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.tasky.reminder.di.ReminderModule
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel

@Destination
@Composable
internal fun ReminderHomeScreen() = HandleKoinModuleInit(module = ReminderModule) {
    val viewModel = getViewModel<ReminderViewModel>()

    TaskyDestinationSurface {

    }
}