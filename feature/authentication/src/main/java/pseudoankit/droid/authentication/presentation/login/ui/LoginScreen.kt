package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.authentication.presentation.login.LoginUiState
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.unify.component.topbar.UnifyTopBarConfig
import pseudoankit.droid.unify.screen.UnifyScreen
import pseudoankit.droid.unify.screen.UnifyScreenConfig
import pseudoankit.droid.unify.token.UnifyDimens

@Destination(
    deepLinks = [
        DeepLink(uriPattern = TaskyDeeplink.login)
    ]
)
@Composable
internal fun LoginScreen(navigator: AuthNavigator) = LoginModule.load {
    val viewModel: LoginViewModel = getViewModel()

    UnifyScreen(
        config = UnifyScreenConfig(
            topBar = UnifyTopBarConfig(title = "Welcome Back")
        ),
        singleEvents = {
            viewModel.container.sideEffectFlow.collectLatest {
                when (it) {
                    LoginUiState.SideEffect.NavigateToHomeScreen -> navigator.navigateToHomeScreen()
                    LoginUiState.SideEffect.NavigateToRegistrationScreen -> navigator.navigateToRegistrationScreen()
                }
            }
        },
        modifier = Modifier.padding(all = UnifyDimens.ScreenPadding)
    ) {
        val state = viewModel.collectAsState().value

        LoginScreenComponents.Email(
            email = state.emailConfig,
            onEmailChanged = viewModel::onEmailValueChanged
        )
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_12))
        LoginScreenComponents.Password(
            password = state.passwordConfig,
            onPasswordChanged = viewModel::onPasswordValueChanged
        )

        Spacer(modifier = Modifier.weight(1f))
        LoginScreenComponents.SignupText(viewModel::onSignup)
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_12))
        LoginScreenComponents.LoginButton(
            state = state.buttonState,
            onLogin = viewModel::onLogin
        )
    }
}
