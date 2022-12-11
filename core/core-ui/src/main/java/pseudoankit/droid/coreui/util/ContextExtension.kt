package pseudoankit.droid.coreui.util

import android.content.Context
import android.widget.Toast
import pseudoankit.droid.core.util.TextResource

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: TextResource) {
    showToast(message.asString(this))
}