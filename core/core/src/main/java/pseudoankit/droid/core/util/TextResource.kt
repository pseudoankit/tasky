package pseudoankit.droid.core.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed interface TextResource {
    class WithResId(internal val stringId: Int, internal vararg val params: Any) : TextResource

    @JvmInline
    value class WithText(internal val text: String) : TextResource

    fun asString(context: Context): String {
        return when (this) {
            is WithResId -> context.resources.getString(stringId, *params)
            is WithText -> text
        }
    }

    @Composable
    fun asString(): String {
        return asString(LocalContext.current)
    }
}