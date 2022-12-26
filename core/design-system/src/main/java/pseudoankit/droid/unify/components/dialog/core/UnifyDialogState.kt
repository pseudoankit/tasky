package pseudoankit.droid.unify.components.dialog.core

import androidx.compose.runtime.*

@Composable
fun rememberUnifyDialogState(initialValue: Boolean = false): UnifyDialogState {
    return remember {
        UnifyDialogState(initialValue = initialValue)
    }
}

class UnifyDialogState internal constructor(initialValue: Boolean = false) {
    internal var showing by mutableStateOf(initialValue)

    fun show() {
        showing = true
    }

    fun hide() {
        showing = false
    }
}