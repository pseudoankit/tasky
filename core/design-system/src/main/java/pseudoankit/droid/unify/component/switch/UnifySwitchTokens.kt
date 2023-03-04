package pseudoankit.droid.unify.component.switch

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.token.UnifyTokens
import pseudoankit.droid.unify.utils.internal.rememberMutableState

internal object UnifySwitchTokens {
    val switchColors
        @Composable get() = object : SwitchColors {
            val defaultColors = SwitchDefaults.colors()

            @Composable
            override fun borderColor(enabled: Boolean, checked: Boolean): State<Color> {
                return rememberMutableState(value = UnifyTokens.Switch.BorderColor)
            }

            @Composable
            override fun iconColor(enabled: Boolean, checked: Boolean): State<Color> {
                return defaultColors.iconColor(enabled = enabled, checked = checked)
            }

            @Composable
            override fun thumbColor(enabled: Boolean, checked: Boolean): State<Color> {
                return rememberMutableState(
                    enabled,
                    value = when (enabled) {
                        true -> UnifyTokens.Switch.ThumbColor.enabled
                        false -> UnifyTokens.Switch.ThumbColor.disabled
                    }
                )
            }

            @Composable
            override fun trackColor(enabled: Boolean, checked: Boolean): State<Color> {
                return rememberMutableState(
                    enabled,
                    value = when (enabled) {
                        true -> UnifyTokens.Switch.TrackColor.enabled
                        false -> UnifyTokens.Switch.TrackColor.disabled
                    }
                )
            }

        }
}