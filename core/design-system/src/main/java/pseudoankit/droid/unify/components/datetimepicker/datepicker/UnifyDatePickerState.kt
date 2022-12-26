package pseudoankit.droid.unify.components.datetimepicker.datepicker

import androidx.compose.runtime.*

@Composable
fun rememberUnifyDatePickerState(initialValue: Boolean = false): UnifyDatePickerState {
    return remember {
        UnifyDatePickerState(initialValue = initialValue)
    }
}

class UnifyDatePickerState internal constructor(initialValue: Boolean = false) {
    internal var showing by mutableStateOf(initialValue)

    fun show() {
        showing = true
    }

    fun hide() {
        showing = false
    }
}