package pseudoankit.droid.unify.components.checkbox

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTokens

object UnifyCheckBox {

    @Composable
    operator fun invoke(config: Config) = with(config) {
        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = modifier,
                enabled = enabled,
                colors = colors
            )
        }
    }

    data class Config(
        val checked: Boolean = false,
        val onCheckedChange: ((Boolean) -> Unit)?,
        val modifier: Modifier = Modifier,
        val enabled: Boolean = true
    )

    private val colors = object : CheckboxColors {
        @Composable
        override fun borderColor(enabled: Boolean, state: ToggleableState): State<Color> {
            return mutableStateOf(UnifyTokens.CheckBox.BackgroundColor)
        }

        @Composable
        override fun boxColor(enabled: Boolean, state: ToggleableState): State<Color> {
            return mutableStateOf(
                when (state) {
                    ToggleableState.On -> UnifyTokens.CheckBox.BackgroundColor
                    else -> UnifyColors.Unspecified
                }
            )
        }

        @Composable
        override fun checkmarkColor(state: ToggleableState): State<Color> {
            return mutableStateOf(UnifyTokens.CheckBox.CheckMarkColor)
        }
    }
}