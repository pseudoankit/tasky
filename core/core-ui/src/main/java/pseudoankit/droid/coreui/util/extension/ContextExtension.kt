package pseudoankit.droid.coreui.util.extension

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.TextResource.Companion.asString

fun Context.finish() {
    (this as? Activity)?.finish()
}

fun Context.navigateToSettings() = try {
    startActivity(
        Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.fromParts("package", packageName, null)
        }
    )
} catch (e: ActivityNotFoundException) {
    showToast("Oops! Something went wrong, Long press app icon -> click on info -> grant permission")
    e.printStackTrace()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: TextResource) {
    showToast(message.asString(this))
}

fun Context.toastNotImplemented() {
    showToast("This feature is not implemented yet!")
}