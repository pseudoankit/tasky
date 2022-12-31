package pseudoankit.droid.unify.components.switch

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.token.UnifyTokens

object UnifySwitch {

    @Composable
    operator fun invoke(config: Config) = with(config) {
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange?.invoke()
            },
            enabled = onCheckedChange != null,
            colors = switchColors
        )
    }

    data class Config(
        val checked: Boolean,
        val onCheckedChange: (() -> Unit)?,
        val modifier: Modifier = Modifier,
    )

    private val switchColors
        @Composable get() = object : SwitchColors {
            val defaultColors = SwitchDefaults.colors()

            @Composable
            override fun borderColor(enabled: Boolean, checked: Boolean): State<Color> {
                return mutableStateOf(UnifyTokens.Switch.BorderColor)
            }

            @Composable
            override fun iconColor(enabled: Boolean, checked: Boolean): State<Color> {
                return defaultColors.iconColor(enabled = enabled, checked = checked)
            }

            @Composable
            override fun thumbColor(enabled: Boolean, checked: Boolean): State<Color> {
                return mutableStateOf(
                    when (enabled) {
                        true -> UnifyTokens.Switch.ThumbColor.enabled
                        false -> UnifyTokens.Switch.ThumbColor.disabled
                    }
                )
            }

            @Composable
            override fun trackColor(enabled: Boolean, checked: Boolean): State<Color> {
                return mutableStateOf(
                    when (enabled) {
                        true -> UnifyTokens.Switch.TrackColor.enabled
                        false -> UnifyTokens.Switch.TrackColor.disabled
                    }
                )
            }

        }
}