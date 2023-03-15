package pseudoankit.droid.unify.component.pill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens
import pseudoankit.droid.unify.utils.clickable

data class UnifyPillConfig(
    val label: String,
    val modifier: Modifier = Modifier,
)

@Composable
fun UnifyPill(
    config: UnifyPillConfig,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = config.modifier
            .clip(RoundedCornerShape(UnifyDimens.Radius.Large))
            .background(color = UnifyColors.Blue400)
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UnifyTextView(config = UnifyTextViewConfig(text = config.label, color = UnifyColors.White))
    }
}
