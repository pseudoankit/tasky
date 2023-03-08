package pseudoankit.droid.unify.component.progressbar

import android.annotation.SuppressLint
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

@Composable
fun UnifyProgressIndicator(
    config: UnifyProgressIndicatorConfig = UnifyProgressIndicatorConfig()
) {
    when (config.type) {
        UnifyProgressIndicatorConfig.Type.Circular -> CircularProgressIndicator(
            modifier = config.modifier,
            color = config.color,
            strokeWidth = config.strokeWidth
        )
    }
}

data class UnifyProgressIndicatorConfig(
    val type: Type = Type.Circular,
    val modifier: Modifier = Modifier,
    val color: Color = UnifyColors.Black,
    val strokeWidth: Dp = UnifyDimens.Dp_4
) {
    enum class Type { Circular }
}