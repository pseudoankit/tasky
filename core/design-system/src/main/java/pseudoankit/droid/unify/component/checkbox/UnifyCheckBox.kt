package pseudoankit.droid.unify.component.checkbox

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
import pseudoankit.droid.unify.utils.internal.rememberMutableState

data class UnifyCheckBoxConfig(
    val checked: Boolean = false,
    val onCheckedChange: ((Boolean) -> Unit)?,
    val modifier: Modifier = Modifier,
    val enabled: Boolean = true
)

@Composable
fun UnifyCheckBox(config: UnifyCheckBoxConfig) = with(config) {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier,
            enabled = enabled,
            colors = UnifyCheckBoxTokens.colors
        )
    }
}