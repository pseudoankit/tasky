package pseudoankit.droid.authentication.presentation.registration

import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class RegistrationViewModel :
    BaseViewModel<RegistrationUiState.State, RegistrationUiState.SideEffect, Nothing>(
        RegistrationUiState.State()
    ) {

    fun navigateBack() = postSideEffect {
        RegistrationUiState.SideEffect.NavigateBack
    }
}