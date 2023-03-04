package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import pseudoankit.droid.coreui.model.TextFieldUiConfig
import pseudoankit.droid.coreui.util.extension.asString
import pseudoankit.droid.coreui.util.extension.noRippleClickable
import pseudoankit.droid.unify.component.button.UnifyButton
import pseudoankit.droid.unify.component.button.UnifyButtonConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldDefaults
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig

internal object LoginScreenComponents {
    @Composable
    fun Email(email: TextFieldUiConfig, onEmailChanged: (String) -> Unit) {
        UnifyTextField(
            config = UnifyTextFieldConfig(
                value = email.value,
                onValueChange = onEmailChanged,
                placeholder = UnifyTextFieldDefaults.placeHolder("Email address"),
                leadingIcon = UnifyIcons.Mail,
                errorMessage = email.errorMessage.asString(),
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Valid,
                showTrailingIcon = email.errorMessage == null
            )
        )
    }

    @Composable
    fun Password(password: TextFieldUiConfig, onPasswordChanged: (String) -> Unit) {
        var isTextHidden by remember { mutableStateOf(false) }

        UnifyTextField(
            config = UnifyTextFieldConfig(
                value = password.value,
                onValueChange = onPasswordChanged,
                placeholder = UnifyTextFieldDefaults.placeHolder("Password"),
                leadingIcon = UnifyIcons.Lock,
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Password(
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
    fun LoginButton(onLogin: () -> Unit, state: UnifyButtonConfig.State) {
        UnifyButton(
            config = UnifyButtonConfig(text = "LOGIN", state = state),
            onClick = onLogin
        )
    }

    // todo change to annotated text
    @Composable
    fun SignupText(onSignup: () -> Unit) {
        UnifyTextView(
            config = UnifyTextViewConfig(
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
