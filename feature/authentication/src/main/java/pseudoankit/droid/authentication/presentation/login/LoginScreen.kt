package pseudoankit.droid.authentication.presentation.login

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig
import pseudoankit.droid.coreui.token.TaskyDestinationSurface

@Destination
@Composable
fun LoginScreen() {

    LoginModule.load()
    val viewModel = getViewModel<LoginViewModel>()

    TaskyDestinationSurface(
        topBarConfig = TaskyTopBarConfig(
            title = "Welcome Back",
            leadingIcon = null
        ),
        content = {
            LoginScreenState(state = viewModel.state.value, event = viewModel::onEvent)
        },
        module = LoginModule,
        singleEvents = {
            viewModel.sideEffect.collect {
                when (it) {
                    LoginSideEffect.NavigateToHomeScreen -> TODO()
                    LoginSideEffect.NavigateToRegistrationScreen -> TODO()
                }
            }
        }
    )
}
