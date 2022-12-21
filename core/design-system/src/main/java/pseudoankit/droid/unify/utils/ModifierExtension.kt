package pseudoankit.droid.unify.utils

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

fun Modifier.clickable(
    onClick: (() -> Unit)?,
    enabled: Boolean = onClick != null,
) = clickable(enabled = enabled, onClick = { onClick?.invoke() }, onClickLabel = null)