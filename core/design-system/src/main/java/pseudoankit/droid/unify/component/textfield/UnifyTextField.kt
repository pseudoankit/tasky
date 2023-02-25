package pseudoankit.droid.unify.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.internal.UnifyBasicTextField
import pseudoankit.droid.unify.component.textfield.internal.UnifyOutlinedTextField
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldInternal
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.utils.rememberFocusRequester

object UnifyTextField {

    @Composable
    operator fun invoke(config: Config) {
        val focusRequester = rememberFocusRequester()
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

        UnifyTextFieldInternal.ManageFocus(config.focusState, focusRequester)
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