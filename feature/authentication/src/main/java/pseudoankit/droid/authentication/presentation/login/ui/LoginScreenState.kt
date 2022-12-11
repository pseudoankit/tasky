package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.components.icon.TaskyIcons
import pseudoankit.droid.coreui.components.textfield.TaskyTextField
import pseudoankit.droid.coreui.components.textfield.TaskyTextFieldConfig
import pseudoankit.droid.coreui.token.TaskyDimens

@Composable
internal fun LoginScreenState(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit
) {
    TaskyTextField(
        config = TaskyTextFieldConfig(
            value = email,
            onValueChange = onEmailChanged,
            placeholder = TextResource.WithString("Email address"),
            leadingIcon = TaskyIcons.Mail
        )
    )
    Spacer(modifier = Modifier.height(TaskyDimens.Dp_12))
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