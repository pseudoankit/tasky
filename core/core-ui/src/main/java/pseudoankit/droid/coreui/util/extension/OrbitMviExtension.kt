package pseudoankit.droid.coreui.util.extension

import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.postSideEffect(
    registerIdling: Boolean = true,
    sideEffect: () -> SIDE_EFFECT
) = intent(registerIdling = registerIdling) {
    postSideEffect(sideEffect())
}

fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.setState(
    registerIdling: Boolean = true,
    state: STATE.() -> STATE
) = intent {
    reduce {
        state(container.stateFlow.value)
    }
}

val <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.state
    get() = container.stateFlow.value