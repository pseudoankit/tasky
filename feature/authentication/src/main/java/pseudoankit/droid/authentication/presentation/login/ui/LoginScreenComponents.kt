package pseudoankit.droid.authentication.presentation.login.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import pseudoankit.droid.core.testtag.AuthTestTag
import pseudoankit.droid.coreui.model.TextFieldUiConfig
import pseudoankit.droid.coreui.util.extension.asString
import pseudoankit.droid.unify.component.button.UnifyButton
import pseudoankit.droid.unify.component.button.UnifyButtonConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.utils.addTestTag
import pseudoankit.droid.unify.utils.clickable

internal object LoginScreenComponents {
    @Composable
    fun Email(email: TextFieldUiConfig, onEmailChanged: (String) -> Unit) {
        UnifyTextField(
            config = UnifyTextFieldConfig(
                value = email.value,
                onValueChange = onEmailChanged,
                label = "Email address",
                leadingIcon = UnifyIcons.Mail,
                errorMessage = email.errorMessage.asString(),
                trailingIcon = if (email.errorMessage != null) UnifyTextFieldConfig.TrailingIcon.Clear else UnifyTextFieldConfig.TrailingIcon.Valid,
                modifier = Modifier
                    .fillMaxWidth()
                    .addTestTag(AuthTestTag.email)
            )
        )
    }

    @Composable
    fun Password(password: TextFieldUiConfig, onPasswordChanged: (String) -> Unit) {
        UnifyTextField(
            config = UnifyTextFieldConfig(
                value = password.value,
                onValueChange = onPasswordChanged,
                label = "Password",
                leadingIcon = UnifyIcons.Lock,
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Password,
                errorMessage = password.errorMessage.asString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .addTestTag(AuthTestTag.password)
            )
        )
    }

    @Composable
    fun LoginButton(onLogin: () -> Unit, state: UnifyButtonConfig.State) {
        UnifyButton(
            config = UnifyButtonConfig(text = "LOGIN", state = state),
            onClick = onLogin,
            modifier = Modifier.addTestTag(AuthTestTag.loginBtn)
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
                    .clickable(onClick = onSignup, showRipple = false)
            )
        )
    }
}
