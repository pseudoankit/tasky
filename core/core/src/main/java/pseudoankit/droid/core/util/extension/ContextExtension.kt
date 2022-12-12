package pseudoankit.droid.core.util.extension

import android.app.Activity
import android.content.Context
import android.widget.Toast
import pseudoankit.droid.core.util.TextResource

fun Context.finish() {
    (this as? Activity)?.finish()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: TextResource) {
    showToast(message.asString(this))
}