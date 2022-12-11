package pseudoankit.droid.authentication.presentation.login

import androidx.compose.runtime.Composable
import pseudoankit.droid.coreui.components.textfield.TaskyTextField
import pseudoankit.droid.coreui.components.textfield.TaskyTextFieldConfig

@Composable
internal fun LoginScreenState(state: LoginState, event: (LoginEvent) -> Unit) {

    TaskyTextField(
        config = TaskyTextFieldConfig(
            value = state.email,
            onValueChange = {
                event(LoginEvent.OnEmailValueChanged(it))
            }
        )
    )
}