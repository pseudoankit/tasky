package pseudoankit.droid.unify.components.switch

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object UnifySwitch {

    @Composable
    operator fun invoke(config: Config) = with(config) {
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange?.invoke()
            },
            enabled = onCheckedChange != null,
            colors = UnifySwitchInternal.switchColors
        )
    }

    data class Config(
        val checked: Boolean,
        val onCheckedChange: (() -> Unit)?,
        val modifier: Modifier = Modifier,
    )
}