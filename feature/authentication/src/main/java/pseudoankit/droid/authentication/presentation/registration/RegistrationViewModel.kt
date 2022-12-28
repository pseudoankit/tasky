package pseudoankit.droid.authentication.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.coreui.util.extension.postSideEffect

internal class RegistrationViewModel : ViewModel(),
    ContainerHost<RegistrationUiState.State, RegistrationUiState.SideEffect> {

    override val container: Container<RegistrationUiState.State, RegistrationUiState.SideEffect> =
        viewModelScope.container(RegistrationUiState.State())

    fun navigateBack() = postSideEffect {
        RegistrationUiState.SideEffect.NavigateBack
    }
}