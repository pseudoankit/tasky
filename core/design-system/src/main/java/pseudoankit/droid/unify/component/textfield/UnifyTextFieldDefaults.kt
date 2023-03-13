package pseudoankit.droid.unify.component.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.delay
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors

object UnifyTextFieldDefaults {

    fun placeHolder(
        value: String,
        textType: UnifyTextType = UnifyTextType.BodyLarge
    ) = UnifyTextViewConfig(
        text = value,
        textType = textType,
        color = UnifyColors.Gray800
    )

    /**
     * Utility method to request focus and open keyboard
     */
    @Composable
    fun ManageFocus(focusState: UnifyTextFieldConfig.FocusState, focusRequester: FocusRequester) {
        val keyboard = LocalSoftwareKeyboardController.current

        LaunchedEffect(focusState) {
            when (focusState) {
                UnifyTextFieldConfig.FocusState.Request -> {
                    focusRequester.requestFocus()
                    delay(100)
                    keyboard?.show()
                }
                UnifyTextFieldConfig.FocusState.Capture -> focusRequester.captureFocus()
                UnifyTextFieldConfig.FocusState.Free -> {
                    focusRequester.freeFocus()
                    delay(100)
                    keyboard?.hide()
                }
                UnifyTextFieldConfig.FocusState.None -> {}
            }
        }
    }
}
