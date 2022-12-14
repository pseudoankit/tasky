package pseudoankit.droid.authentication.presentation.registration

import pseudoankit.droid.core.viewmodel.BaseViewModel

internal class RegistrationViewModel :
    BaseViewModel<RegistrationState, RegistrationSideEffect>(RegistrationState()) {

    fun navigateBack() = postSideEffect {
        RegistrationSideEffect.NavigateBack
    }
}