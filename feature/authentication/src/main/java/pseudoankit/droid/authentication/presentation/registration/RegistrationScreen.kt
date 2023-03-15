package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.authentication.di.RegistrationModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.topbar.UnifyTopBarConfig
import pseudoankit.droid.unify.screen.UnifyScreen
import pseudoankit.droid.unify.screen.UnifyScreenConfig

@Destination
@Composable
internal fun RegistrationScreen(navigator: AuthNavigator) = RegistrationModule.load {
    val viewModel: RegistrationViewModel = getViewModel()

    UnifyScreen(
        config = UnifyScreenConfig(
            topBar = UnifyTopBarConfig(
                title = "Create your account",
                leadingIcon = UnifyIconConfig(
                    icon = UnifyIcons.Back,
                    onClick = {
                        viewModel.onEvent(RegistrationUiState.Event.OnNavigateBack)
                    }
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
        val state = viewModel.collectAsState().value

        UnifyTextField(
            config = UnifyTextFieldConfig(
                label = "Name",
                value = state.name,
                onValueChange = {
                    viewModel.onEvent(RegistrationUiState.Event.OnNameChanged(it))
                }
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        UnifyTextField(
            config = UnifyTextFieldConfig(
                label = "Email",
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(RegistrationUiState.Event.OnEmailChanged(it))
                }
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        UnifyTextField(
            config = UnifyTextFieldConfig(
                label = "Password",
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(RegistrationUiState.Event.OnPasswordChanged(it))
                },
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Password
            )
        )
    }
}
