package pseudoankit.droid.core.util

import android.app.Activity
import android.content.Context

fun Context.finish() {
    (this as? Activity)?.finish()
}