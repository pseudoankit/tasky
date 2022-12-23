package pseudoankit.droid.unify.components.switch

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.token.UnifyColors

internal object UnifySwitchInternal {

    val switchColors
        @Composable get() = object : SwitchColors {
            val defaultColors = SwitchDefaults.colors()

            @Composable
            override fun borderColor(enabled: Boolean, checked: Boolean): State<Color> {
                return mutableStateOf(UnifyColors.Transparent)
            }

            @Composable
            override fun iconColor(enabled: Boolean, checked: Boolean): State<Color> {
                return defaultColors.iconColor(enabled = enabled, checked = checked)
            }

            @Composable
            override fun thumbColor(enabled: Boolean, checked: Boolean): State<Color> {
                return mutableStateOf(
                    when (enabled) {
                        true -> UnifyColors.Black
                        false -> UnifyColors.Gray
                    }
                )
            }

            @Composable
            override fun trackColor(enabled: Boolean, checked: Boolean): State<Color> {
                return mutableStateOf(
                    when (enabled) {
                        true -> UnifyColors.Black.copy(alpha = .1f)
                        false -> UnifyColors.Gray.copy(alpha = .42f)
                    }
                )
            }

        }
}