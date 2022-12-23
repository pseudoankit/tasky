package pseudoankit.droid.unify.components.textfield.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.delay
import pseudoankit.droid.unify.components.textfield.UnifyTextField

object UnifyTextFieldInternal {

    @Composable
    fun ManageFocus(focusState: UnifyTextField.FocusState, focusRequester: FocusRequester) {
        val keyboard = LocalSoftwareKeyboardController.current

        LaunchedEffect(focusState) {
            when (focusState) {
                UnifyTextField.FocusState.Request -> {
                    focusRequester.requestFocus()
                    delay(100)
                    keyboard?.show()
                }
                UnifyTextField.FocusState.Capture -> focusRequester.captureFocus()
                UnifyTextField.FocusState.Free -> {
                    focusRequester.freeFocus()
                    delay(100)
                    keyboard?.hide()
                }
                UnifyTextField.FocusState.None -> {}
            }
        }
    }
}