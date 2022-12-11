package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.navigator.LoginNavigator
import pseudoankit.droid.authentication.presentation.login.LoginSideEffect
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig
import pseudoankit.droid.coreui.token.TaskyDestinationSurface

@Destination
@Composable
internal fun LoginScreen(
    navigator: LoginNavigator
) {

    LoginModule.load()
    val viewModel = getViewModel<LoginViewModel>()

    TaskyDestinationSurface(
        topBarConfig = TaskyTopBarConfig(
            title = "Welcome Back",
            leadingIcon = null
        ),
        content = {
            val state = viewModel.state.value
            LoginScreenState(
                email = state.email,
                password = state.password,
                onEmailChanged = viewModel::onEmailValueChanged,
                onPasswordChanged = viewModel::onPasswordValueChanged,
            )
        },
        module = LoginModule,
        singleEvents = {
            viewModel.sideEffect.collect {
                when (it) {
                    LoginSideEffect.NavigateToHomeScreen -> navigator.navigateToHome()
                    LoginSideEffect.NavigateToRegistrationScreen -> navigator.navigateToRegistrationScreen()
                }
            }
        }
    )
}
