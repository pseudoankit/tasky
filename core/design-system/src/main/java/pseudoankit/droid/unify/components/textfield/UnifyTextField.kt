package pseudoankit.droid.unify.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.delay
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textfield.internal.UnifyBasicTextField
import pseudoankit.droid.unify.components.textfield.internal.UnifyOutlinedTextField
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.utils.rememberFocusRequester

object UnifyTextField {

    @Composable
    operator fun invoke(config: Config) {
        val focusRequester = rememberFocusRequester()
        val keyboard = LocalSoftwareKeyboardController.current
        val modifiedConfig = if (config.focusState == FocusState.None) {
            config
        } else {
            config.copy(modifier = config.modifier.focusRequester(focusRequester))
        }

        when (config.type) {
            Type.Outlined -> {
                UnifyOutlinedTextField(modifiedConfig)
            }
            Type.Basic -> {
                UnifyBasicTextField(modifiedConfig)
            }
        }

        LaunchedEffect(config.focusState) {
            when (config.focusState) {
                FocusState.Request -> {
                    focusRequester.requestFocus()
                    delay(100)
                    keyboard?.show()
                }
                FocusState.Capture -> focusRequester.captureFocus()
                FocusState.Free -> {
                    focusRequester.freeFocus()
                    delay(100)
                    keyboard?.hide()
                }
                FocusState.None -> {}
            }
        }
    }

    enum class Type { Outlined, Basic }

    data class Config(
        val value: String,
        val onValueChange: (String) -> Unit,
        val keyboardType: KeyboardType = KeyboardType.Text,
        val placeholder: UnifyTextView.Config? = null,
        val leadingIcon: UnifyIcons? = null,
        val trailingIcon: TrailingIcon? = null,
        val showTrailingIcon: Boolean = true,
        val errorMessage: String? = null,
        val modifier: Modifier = Modifier.fillMaxWidth(),
        val maxLines: Int = Int.MAX_VALUE,
        val textType: UnifyTextType = UnifyTextType.BodyLarge,
        val type: Type = Type.Outlined,
        val focusState: FocusState = FocusState.None
    )

    enum class FocusState {
        Request, Capture, Free, None
    }

    sealed interface TrailingIcon {
        object Valid : TrailingIcon
        data class Password(
            val isTextHidden: Boolean = false,
            val onVisibilityToggled: () -> Unit
        ) : TrailingIcon

        data class Custom(val icon: UnifyIcons, val onClick: () -> Unit) : TrailingIcon
    }
}