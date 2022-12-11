package pseudoankit.droid.authentication.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class LoginViewModel : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val _sideEffect: MutableSharedFlow<LoginSideEffect> = MutableSharedFlow()
    val sideEffect: Flow<LoginSideEffect> = _sideEffect


}