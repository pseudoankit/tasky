package pseudoankit.droid.unify.components.divider

import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object UnifyDivider {

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        color: Color = DividerDefaults.color,
        height: Dp = DividerDefaults.Thickness,
        startIndent: Dp = 0.dp
    ) {
        Divider(modifier, color, height, startIndent)
    }
}