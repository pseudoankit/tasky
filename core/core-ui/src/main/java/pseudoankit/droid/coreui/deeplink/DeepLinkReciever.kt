package pseudoankit.droid.coreui.deeplink

import androidx.navigation.NavController
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.logger.TaskyLogger

fun NavController.navigateViaDeepLink(deepLink: String) = try{
    val internalRoute = TaskyDeeplink.mapToInternalRoute(deepLink)
    navigate(internalRoute)
} catch (e: IllegalArgumentException) {
    e.printStackTrace()
    TaskyLogger.error("error occurred while performing navigation on [$deepLink] deeplink")
}

