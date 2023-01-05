package pseudoankit.droid.unify.components.card

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

object UnifyCard {

    @Composable
    operator fun invoke(config: Config = Config(), content: @Composable () -> Unit) {
        Surface(
            modifier = config.modifier.then(Modifier.padding(UnifyDimens.Dp_1)),
            shape = RoundedCornerShape(config.radius),
            color = config.color,
            content = content,
            shadowElevation = UnifyDimens.Dp_1,
            tonalElevation = UnifyDimens.Dp_1,
            onClick = config.onClick,
            enabled = config.enabled
        )
    }

    data class Config(
        val radius: Dp = UnifyDimens.Radius.Medium,
        val color: Color = UnifyColors.White,
        val onClick: () -> Unit = {},
        val enabled: Boolean = true,
        val modifier: Modifier = Modifier
    )
}