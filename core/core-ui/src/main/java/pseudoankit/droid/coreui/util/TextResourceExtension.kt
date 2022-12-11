package pseudoankit.droid.coreui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import pseudoankit.droid.core.util.TextResource

@Composable
fun TextResource.asString(): String {
    return asString(LocalContext.current)
}