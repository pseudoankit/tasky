package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.RegistrationModule
import pseudoankit.droid.authentication.navigator.AuthNavigator

import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.coreui.surface.TaskyDestinationSurfaceConfig
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.topbar.UnifyTopBar

@Destination
@Composable
internal fun RegistrationScreen(navigator: AuthNavigator) = RegistrationModule.load {
    val viewModel: RegistrationViewModel = getViewModel()

    TaskyDestinationSurface(
        config = TaskyDestinationSurfaceConfig(
            topBar = UnifyTopBar.Config(
                title = "Create your account",
                leadingIcon = UnifyIcon.Config(
                    icon = UnifyIcons.Back,
                    onClick = viewModel::navigateBack
                )
            )
        ),
        singleEvents = {
            viewModel.container.sideEffectFlow.collectLatest {
                when (it) {
                    RegistrationUiState.SideEffect.NavigateBack -> navigator.navigateUp()
                }
            }
        }
    ) {

    }
}