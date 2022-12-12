package pseudoankit.droid.coreui.components.progressbar

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens

object UnifyProgressIndicator {
    data class Config(
        val type: Type = Type.Circular,
        val modifier: Modifier = Modifier,
        val color: Color = UnifyColors.Unspecified,
        val strokeWidth: Dp = UnifyDimens.Dp_4
    )

    enum class Type { Circular }
}

@Composable
fun UnifyProgressIndicator(config: UnifyProgressIndicator.Config = UnifyProgressIndicator.Config()) {
    when (config.type) {
        UnifyProgressIndicator.Type.Circular -> CircularProgressIndicator(
            modifier = config.modifier,
            color = config.color,
            strokeWidth = config.strokeWidth
        )
    }
}