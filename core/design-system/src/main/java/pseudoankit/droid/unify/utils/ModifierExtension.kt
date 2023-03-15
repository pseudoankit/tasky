package pseudoankit.droid.unify.utils

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import pseudoankit.droid.unify.token.UnifyColors

fun Modifier.clickable(
    onClick: (() -> Unit)?,
    showRipple: Boolean = onClick != null
) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = if (showRipple) LocalIndication.current else null,
        role = null,
        onClick = { onClick?.invoke() },
        enabled = onClick != null
    )
}

/**
 * Adds a shimmer loading indicator when the [isLoading] flag is set to true.
 */
fun Modifier.isLoading(isLoading: Boolean) = composed {
    this.placeholder(
        visible = isLoading,
        highlight = PlaceholderHighlight.shimmer(),
        color = UnifyColors.Gray100
    )
}