package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.coreui.model.TextFieldUiConfig
import pseudoankit.droid.unify.component.button.UnifyButton
import pseudoankit.droid.unify.component.button.UnifyButtonConfig

object LoginUiState {

    // TEST remove def values later on
    internal data class State(
        val emailConfig: TextFieldUiConfig = TextFieldUiConfig(
            value = "lostankit7@gmail.com",
            errorMessage = null
        ),
        val passwordConfig: TextFieldUiConfig = TextFieldUiConfig(
            value = "qwerty",
            errorMessage = null
        ),
        val isButtonLoading: Boolean = false
    ) {
        val buttonState
            get() = UnifyButtonConfig.State.fromBoolean(
                isValid = emailConfig.errorMessage == null && passwordConfig.errorMessage == null,
                isLoading = isButtonLoading
            )
    }

    internal sealed interface SideEffect {
        object NavigateToRegistrationScreen : SideEffect
        object NavigateToHomeScreen : SideEffect
    }
}