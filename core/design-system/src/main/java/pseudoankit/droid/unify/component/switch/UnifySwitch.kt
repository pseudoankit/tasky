package pseudoankit.droid.unify.component.switch

import android.annotation.SuppressLint
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.token.UnifyTokens
import pseudoankit.droid.unify.utils.internal.rememberMutableState

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
        colors = UnifySwitchTokens.switchColors
    )
}
