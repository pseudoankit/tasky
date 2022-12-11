package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.navigator.LoginNavigator
import pseudoankit.droid.authentication.presentation.login.LoginSideEffect
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.coreui.components.icon.TaskyIconConfig
import pseudoankit.droid.coreui.components.icon.TaskyIcons
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
            leadingIcon = if (navigator.showBackButton()) {
                TaskyIconConfig(icon = TaskyIcons.Back)
            } else null
        ),
        module = LoginModule,
        singleEvents = {
            viewModel.sideEffect.collect {
                when (it) {
                    LoginSideEffect.NavigateToHomeScreen -> navigator.navigateToHome()
                    LoginSideEffect.NavigateToRegistrationScreen -> navigator.navigateToRegistrationScreen()
                }
            }
        }
    ) {
        val state = viewModel.state.value

        LoginScreenComponent.Email(
            email = state.email,
            onEmailChanged = viewModel::onEmailValueChanged
        )
        Spacer(modifier = Modifier.height(12.dp))
        LoginScreenComponent.Password(
            password = state.password,
            onPasswordChanged = viewModel::onPasswordValueChanged
        )
    }
}
