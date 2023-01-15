package pseudoankit.droid.unify.utils

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusRequester
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import pseudoankit.droid.unify.token.UnifyColors

fun Modifier.clickable(
    onClick: (() -> Unit)?,
    enabled: Boolean = onClick != null,
) = clickable(enabled = enabled, onClick = { onClick?.invoke() }, onClickLabel = null)

@Composable
fun rememberFocusRequester() = remember {
    FocusRequester()
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