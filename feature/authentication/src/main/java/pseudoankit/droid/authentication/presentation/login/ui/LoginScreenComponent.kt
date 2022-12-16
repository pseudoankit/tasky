package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import pseudoankit.droid.core.util.extension.noRippleClickable
import pseudoankit.droid.coreui.components.button.UnifyButton
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.components.textfield.UnifyTextField

internal object LoginScreenComponent {
    @Composable
    fun Email(email: String, onEmailChanged: (String) -> Unit) {
        UnifyTextField(
            config = UnifyTextField.Config(
                value = email,
                onValueChange = onEmailChanged,
                placeholder = "Email address",
                leadingIcon = UnifyIcons.Mail
            )
        )
    }

    @Composable
    fun Password(password: String, onPasswordChanged: (String) -> Unit) {
        UnifyTextField(
            config = UnifyTextField.Config(
                value = password,
                onValueChange = onPasswordChanged,
                placeholder = "Password",
                leadingIcon = UnifyIcons.Lock,
                trailingIcon = UnifyTextField.Icon.Password
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
