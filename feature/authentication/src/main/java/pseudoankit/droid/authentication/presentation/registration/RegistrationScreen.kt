package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.RegistrationModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.topbar.UnifyTopBar
import pseudoankit.droid.coreui.surface.CoreKoinComposable
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface

@Destination
@Composable
internal fun RegistrationScreen(navigator: AuthNavigator) =
    CoreKoinComposable(module = RegistrationModule) {
        RegistrationScreenInternal(navigator = navigator)
    }

@Composable
private fun RegistrationScreenInternal(
    navigator: AuthNavigator,
    viewModel: RegistrationViewModel = getViewModel(),
) {
    TaskyDestinationSurface(
        topBarConfig = UnifyTopBar.Config(
            title = "Create your account",
            leadingIcon = UnifyIcon.Config(
                icon = UnifyIcons.Back,
                onClick = viewModel::navigateBack
            )
        ),
        singleEvents = {
            viewModel.sideEffect.collect {
                when (it) {
                    RegistrationUiState.SideEffect.NavigateBack -> navigator.navigateUp()
                }
            }
        }
    ) {

    }
}