package pseudoankit.droid.unify.component.checkbox

import androidx.compose.material3.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTokens
import pseudoankit.droid.unify.utils.internal.rememberMutableState

internal object UnifyCheckBoxTokens {

    val colors = object : CheckboxColors {
        @Composable
        override fun borderColor(enabled: Boolean, state: ToggleableState): State<Color> {
            return rememberMutableState(value = UnifyTokens.CheckBox.BackgroundColor)
        }

        @Composable
        override fun boxColor(enabled: Boolean, state: ToggleableState): State<Color> {
            return rememberMutableState(
                state,
                value = when (state) {
                    ToggleableState.On -> UnifyTokens.CheckBox.BackgroundColor
                    else -> UnifyColors.Unspecified
                }
            )
        }

        @Composable
        override fun checkmarkColor(state: ToggleableState): State<Color> {
            return rememberMutableState(value = UnifyTokens.CheckBox.CheckMarkColor)
        }
    }
}