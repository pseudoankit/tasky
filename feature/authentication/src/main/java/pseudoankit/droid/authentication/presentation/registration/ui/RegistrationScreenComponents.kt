package pseudoankit.droid.authentication.presentation.registration.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pseudoankit.droid.authentication.presentation.registration.RegistrationUiState
import pseudoankit.droid.coreui.util.extension.asString
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.topbar.UnifyTopBarConfig

internal object RegistrationScreenComponents {

    @Composable
    fun ColumnScope.RegistrationInputFields(
        state: RegistrationUiState.State,
        onEvent: (RegistrationUiState.Event) -> Unit
    ) {
        UnifyTextField(
            config = UnifyTextFieldConfig(
                label = "Name",
                value = state.nameConfig.value,
                onValueChange = {
                    onEvent(RegistrationUiState.Event.OnNameChanged(it))
                },
                leadingIcon = UnifyIcons.User,
                errorMessage = state.nameConfig.errorMessage?.asString(),
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Clear
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        UnifyTextField(
            config = UnifyTextFieldConfig(
                label = "Email",
                value = state.emailConfig.value,
                onValueChange = {
                    onEvent(RegistrationUiState.Event.OnEmailChanged(it))
                },
                leadingIcon = UnifyIcons.Mail,
                errorMessage = state.emailConfig.errorMessage?.asString(),
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Clear
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        UnifyTextField(
            config = UnifyTextFieldConfig(
                label = "Password",
                value = state.passwordConfig.value,
                onValueChange = {
                    onEvent(RegistrationUiState.Event.OnPasswordChanged(it))
                },
                trailingIcon = UnifyTextFieldConfig.TrailingIcon.Password,
                leadingIcon = UnifyIcons.Lock,
                errorMessage = state.passwordConfig.errorMessage?.asString()
            )
        )
    }

    fun topBar(onEvent: (RegistrationUiState.Event) -> Unit): UnifyTopBarConfig {
        return UnifyTopBarConfig(
            title = "Create your account",
            leadingIcon = UnifyIconConfig(
                icon = UnifyIcons.Back,
                onClick = {
                    onEvent(RegistrationUiState.Event.OnNavigateBack)
                }
            )
        )
    }
}