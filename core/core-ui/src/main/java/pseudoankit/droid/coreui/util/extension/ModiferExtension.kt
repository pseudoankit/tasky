package pseudoankit.droid.coreui.util.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@Composable
fun Modifier.noRippleClickable(onClick: () -> Unit) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        role = null,
        onClick = onClick
    )
}
