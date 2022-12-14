package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.di.RegistrationModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.topbar.UnifyTopBar
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface

@Destination
@Composable
fun RegistrationScreen(
    navigator: AuthNavigator
) {
    RegistrationModule.load()
    RegistrationScreenInternal(navigator = navigator)
}

@Composable
private fun RegistrationScreenInternal(
    viewModel: RegistrationViewModel = getViewModel(),
    navigator: AuthNavigator
) {
    TaskyDestinationSurface(
        topBarConfig = UnifyTopBar.Config(
            title = "Create your account",
            leadingIcon = if (navigator.showBackButton()) {
                UnifyIcon.Config(icon = UnifyIcons.Back, onClick = viewModel::navigateBack)
            } else null
        ),
        module = LoginModule,
        singleEvents = {
            viewModel.sideEffect.collect {
                when (it) {
                    RegistrationSideEffect.NavigateBack -> navigator.navigateUp()
                }
            }
        }
    ) {

    }
}