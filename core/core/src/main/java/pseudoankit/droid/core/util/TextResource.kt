package pseudoankit.droid.core.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed interface TextResource {
    class ResourceString(internal val stringId: Int, internal vararg val params: Any) : TextResource

    @JvmInline
    value class NormalString(internal val text: String) : TextResource

    companion object {
        fun TextResource?.asString(context: Context): String {
            return when (this) {
                null -> ""
                is ResourceString -> context.resources.getString(stringId, *params)
                is NormalString -> text
            }
        }

        @Composable
        fun TextResource?.asString(): String {
            return asString(LocalContext.current)
        }
    }
}