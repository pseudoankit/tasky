package pseudoankit.droid.unify.component.switch

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class UnifySwitchConfig(
    val checked: Boolean,
    val onCheckedChange: (() -> Unit)?,
    val modifier: Modifier = Modifier,
)

@Composable
fun UnifySwitch(config: UnifySwitchConfig) = with(config) {
    Switch(
        checked = checked,
        onCheckedChange = {
            onCheckedChange?.invoke()
        },
        enabled = onCheckedChange != null,
        colors = UnifySwitchTokens.colors()
    )
}
