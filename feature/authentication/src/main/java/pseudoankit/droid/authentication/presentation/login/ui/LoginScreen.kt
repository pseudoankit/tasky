package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.authentication.presentation.login.LoginSideEffect
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.topbar.UnifyTopBar
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.coreui.token.UnifyDimens

@Destination
@Composable
internal fun LoginScreen(
    navigator: AuthNavigator
) {

    // todo find a solution
    LoginModule.load()
    val viewModel = getViewModel<LoginViewModel>()

    TaskyDestinationSurface(
        topBarConfig = UnifyTopBar.Config(
            title = "Welcome Back",
            leadingIcon = if (navigator.showBackButton()) {
                UnifyIcon.Config(icon = UnifyIcons.Back, onClick = viewModel::onNavigateUp)
            } else null
        ),
        module = LoginModule,
        singleEvents = {
            viewModel.sideEffect.collect {
                when (it) {
                    LoginSideEffect.NavigateToHomeScreen -> navigator.navigateToHome()
                    LoginSideEffect.NavigateToRegistrationScreen -> navigator.navigateToRegistrationScreen()
                    LoginSideEffect.NavigateBack -> navigator.navigateUp()
                }
            }
        }
    ) {
        val state = viewModel.state.value

        LoginScreenComponent.Email(
            email = state.email,
            onEmailChanged = viewModel::onEmailValueChanged
        )
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_12))
        LoginScreenComponent.Password(
            password = state.password,
            onPasswordChanged = viewModel::onPasswordValueChanged
        )
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_12))
        LoginScreenComponent.LoginButton(
            state = state.buttonState,
            onLogin = viewModel::onLogin
        )
        Spacer(modifier = Modifier.weight(1f))
        LoginScreenComponent.SignupText(viewModel::onSignup)
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_32))
    }
}
