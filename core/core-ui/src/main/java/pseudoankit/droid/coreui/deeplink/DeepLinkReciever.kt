package pseudoankit.droid.coreui.deeplink

import android.net.Uri
import androidx.navigation.NavController
import pseudoankit.droid.core.logger.logError

fun NavController.navigateViaDeepLink(deepLink: String) {
    navigateViaDeepLink(Uri.parse(deepLink))
}

fun NavController.navigateViaDeepLink(uri: Uri?) = try {
    navigate(uri!!)
} catch (e: IllegalArgumentException) {
    e.printStackTrace()
    logError("deeplink [${uri}] failed with error msg ${e.message}")
}
