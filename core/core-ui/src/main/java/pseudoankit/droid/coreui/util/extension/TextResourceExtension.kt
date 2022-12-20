package pseudoankit.droid.coreui.util.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.TextResource.Companion.asString

@Composable
fun TextResource?.asString(): String {
    return this.asString(LocalContext.current)
}