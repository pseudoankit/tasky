package pseudoankit.droid.coreui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<STATE, SIDE_EFFECT, EVENT>(
    initialState: STATE
) : ViewModel() {

    private val _state: MutableState<STATE> = mutableStateOf(initialState)
    val state: STATE by _state

    private val _sideEffect: MutableSharedFlow<SIDE_EFFECT> = MutableSharedFlow()
    val sideEffect: Flow<SIDE_EFFECT> = _sideEffect

    fun setState(block: STATE.() -> STATE) {
        _state.value = state.block()
    }

    fun postSideEffect(block: () -> SIDE_EFFECT) = intent {
        _sideEffect.emit(block())
    }

    fun intent(
        context: CoroutineContext = Dispatchers.IO,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(context, start, block)
    }

    fun onEvent(event: EVENT) {}
}