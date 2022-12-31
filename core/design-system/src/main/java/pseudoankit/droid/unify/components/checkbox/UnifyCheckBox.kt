package pseudoankit.droid.unify.components.checkbox

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object UnifyCheckBox {

    @Composable
    operator fun invoke(config: Config) = with(config) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier,
            enabled = enabled
        )
    }

    data class Config(
        val checked: Boolean = false,
        val onCheckedChange: ((Boolean) -> Unit)?,
        val modifier: Modifier = Modifier,
        val enabled: Boolean = true
    )
}