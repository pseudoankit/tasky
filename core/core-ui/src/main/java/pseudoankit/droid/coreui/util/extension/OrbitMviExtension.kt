package pseudoankit.droid.coreui.util.extension

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.launch(
    dispatcher: CoroutineDispatcher? = null,
    transformer: suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit
) = intent {
    if (dispatcher == null) {
        return@intent transformer()
    }
    withContext(dispatcher) {
        transformer()
    }
}

fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.postSideEffect(
    sideEffect: () -> SIDE_EFFECT
) = intent {
    postSideEffect(sideEffect())
}

fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.setState(
    state: STATE.() -> STATE
) = intent {
    reduce {
        state(container.stateFlow.value)
    }
}

val <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.state
    get() = container.stateFlow.value