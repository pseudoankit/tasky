package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import pseudoankit.droid.coreui.model.TextFieldUiConfig
import pseudoankit.droid.coreui.util.extension.asString
import pseudoankit.droid.coreui.util.extension.noRippleClickable
import pseudoankit.droid.unify.components.button.UnifyButton
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView

internal object LoginScreenComponents {
    @Composable
    fun Email(email: TextFieldUiConfig, onEmailChanged: (String) -> Unit) {
        UnifyTextField(
            config = UnifyTextField.Config(
                value = email.value,
                onValueChange = onEmailChanged,
                placeholder = "Email address",
                leadingIcon = UnifyIcons.Mail,
                errorMessage = email.errorMessage.asString(),
                trailingIcon = UnifyTextField.TrailingIcon.Valid,
                showTrailingIcon = email.errorMessage == null
            )
        )
    }

    @Composable
    fun Password(password: TextFieldUiConfig, onPasswordChanged: (String) -> Unit) {
        var isTextHidden by remember { mutableStateOf(false) }

        UnifyTextField(
            config = UnifyTextField.Config(
                value = password.value,
                onValueChange = onPasswordChanged,
                placeholder = "Password",
                leadingIcon = UnifyIcons.Lock,
                trailingIcon = UnifyTextField.TrailingIcon.Password(
                    isTextHidden = isTextHidden,
                    onVisibilityToggled = {
                        isTextHidden = isTextHidden.not()
                    }
                ),
                errorMessage = password.errorMessage.asString()
            )
        )
    }

    @Composable
    fun LoginButton(onLogin: () -> Unit, state: UnifyButton.State) {
        UnifyButton(config = UnifyButton.Config(text = "LOGIN", onClick = onLogin, state = state))
    }

    // todo change to annotated text
    @Composable
    fun SignupText(onSignup: () -> Unit) {
        UnifyTextView(
            config = UnifyTextView.Config(
                text = "DON'T HAVE AN ACCOUNT? SIGNUP",
                textType = UnifyTextType.BodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable(onClick = onSignup)
            )
        )
    }
}
