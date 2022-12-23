package pseudoankit.droid.unify.utils

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester

fun Modifier.clickable(
    onClick: (() -> Unit)?,
    enabled: Boolean = onClick != null,
) = clickable(enabled = enabled, onClick = { onClick?.invoke() }, onClickLabel = null)

@Composable
fun rememberFocusRequester() = remember {
    FocusRequester()
}