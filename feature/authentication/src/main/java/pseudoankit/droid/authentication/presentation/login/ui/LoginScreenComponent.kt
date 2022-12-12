package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.runtime.Composable
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.components.button.TaskyButton
import pseudoankit.droid.coreui.components.button.TaskyButtonConfig
import pseudoankit.droid.coreui.components.icon.TaskyIcons
import pseudoankit.droid.coreui.components.textfield.TaskyTextField
import pseudoankit.droid.coreui.components.textfield.TaskyTextFieldConfig

internal object LoginScreenComponent {
    @Composable
    fun Email(email: String, onEmailChanged: (String) -> Unit) {
        TaskyTextField(
            config = TaskyTextFieldConfig(
                value = email,
                onValueChange = onEmailChanged,
                placeholder = TextResource.WithString("Email address"),
                leadingIcon = TaskyIcons.Mail
            )
        )
    }

    @Composable
    fun Password(password: String, onPasswordChanged: (String) -> Unit) {
        TaskyTextField(
            config = TaskyTextFieldConfig(
                value = password,
                onValueChange = onPasswordChanged,
                placeholder = TextResource.WithString("Password"),
                leadingIcon = TaskyIcons.Lock,
                trailingIcon = TaskyTextFieldConfig.Icon.Password
            )
        )
    }

    @Composable
    fun LoginButton(onLogin: () -> Unit, state: TaskyButtonConfig.State) {
        TaskyButton(config = TaskyButtonConfig(text = "LOGIN", onClick = onLogin, state = state))
    }

    @Composable
    fun SignupText(onSignup: () -> Unit) {
        TaskyButton(
            config = TaskyButtonConfig(
                "SIGN UP",
                onClick = onSignup
            )
        )
    }
}
