package pseudoankit.droid.unify.components.progressbar

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

object UnifyProgressIndicator {

    @Composable
    operator fun invoke(config: Config = Config()) {
        when (config.type) {
            Type.Circular -> CircularProgressIndicator(
                modifier = config.modifier,
                color = config.color,
                strokeWidth = config.strokeWidth
            )
        }
    }

    data class Config(
        val type: Type = Type.Circular,
        val modifier: Modifier = Modifier,
        val color: Color = UnifyColors.Black,
        val strokeWidth: Dp = UnifyDimens.Dp_4
    )

    enum class Type { Circular }
}