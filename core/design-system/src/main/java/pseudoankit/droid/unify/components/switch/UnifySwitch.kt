package pseudoankit.droid.unify.components.switch

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object UnifySwitch {

    @Composable
    operator fun invoke(config: Config) = with(config) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = config.enabled,
            colors = UnifySwitchInternal.switchColors
        )
    }

    data class Config(
        val checked: Boolean,
        val onCheckedChange: ((Boolean) -> Unit)?,
        val modifier: Modifier = Modifier,
        val enabled: Boolean = true
    )
}