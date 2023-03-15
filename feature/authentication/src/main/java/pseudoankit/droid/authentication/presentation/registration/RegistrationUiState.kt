package pseudoankit.droid.authentication.presentation.registration

import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.model.TextFieldUiConfig
import pseudoankit.droid.unify.component.button.UnifyButtonConfig

interface RegistrationUiState {
    data class State(
        val emailConfig: TextFieldUiConfig = TextFieldUiConfig(
            value = "",
            errorMessage = null
        ),
        val passwordConfig: TextFieldUiConfig = TextFieldUiConfig(
            value = "",
            errorMessage = null
        ),
        val nameConfig: TextFieldUiConfig = TextFieldUiConfig(
            value = "",
            errorMessage = null
        ),
        val isRegistrationInProgress: Boolean = false
    ) {
        val doneBtnState = UnifyButtonConfig.State.fromBoolean(
            isValid = true,
            isLoading = isRegistrationInProgress
        )
    }

    sealed interface SideEffect {
        object NavigateBack : SideEffect
        data class ShowErrorMessage(val message: TextResource) : SideEffect
    }

    sealed interface Event {
        data class OnNameChanged(val value: String) : Event
        data class OnEmailChanged(val value: String) : Event
        data class OnPasswordChanged(val value: String) : Event
        object OnNavigateBack : Event
        object OnRegisterUser : Event
    }
}