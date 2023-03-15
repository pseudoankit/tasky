package pseudoankit.droid.authentication.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.setState

internal class RegistrationViewModel : ViewModel(),
    ContainerHost<RegistrationUiState.State, RegistrationUiState.SideEffect> {

    override val container: Container<RegistrationUiState.State, RegistrationUiState.SideEffect> =
        viewModelScope.container(RegistrationUiState.State())

    fun onEvent(event: RegistrationUiState.Event) = when (event) {
        is RegistrationUiState.Event.OnEmailChanged -> setState {
            copy(email = event.value)
        }
        is RegistrationUiState.Event.OnNameChanged -> setState {
            copy(name = event.value)
        }
        is RegistrationUiState.Event.OnPasswordChanged -> setState {
            copy(password = event.value)
        }
        RegistrationUiState.Event.OnNavigateBack -> postSideEffect {
            RegistrationUiState.SideEffect.NavigateBack
        }
    }
}