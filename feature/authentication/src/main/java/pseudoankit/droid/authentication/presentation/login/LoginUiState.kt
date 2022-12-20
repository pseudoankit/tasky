package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.core.util.validator.Validator
import pseudoankit.droid.coreui.components.button.UnifyButton

object LoginUiState {

    // todo remove def values later on
    internal data class State(
        val email: String = "lostankit7@gmail.com",
        val password: String = "qwerty",
        val isButtonLoading: Boolean = false
    ) {
        val buttonState =
            UnifyButton.State.fromBoolean(Validator.validate(email, password), isButtonLoading)
    }

    internal sealed interface SideEffect {
        object NavigateBack : SideEffect
        object NavigateToRegistrationScreen : SideEffect
        object NavigateToHomeScreen : SideEffect
    }
}