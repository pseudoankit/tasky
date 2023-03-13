package pseudoankit.droid.coreui.deeplink

import androidx.navigation.NavController
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.logger.TaskyLogger

fun NavController.navigateViaDeepLink(deepLink: String) = try{
    val internalRoute = deepLink.mapToInternalRoute()
    navigate(internalRoute)
} catch (e: IllegalArgumentException) {
    e.printStackTrace()
    TaskyLogger.error("error occurred while performing navigation on [$deepLink] deeplink")
}

private fun String.mapToInternalRoute() = when {
    contains(TaskyDeeplink.Host.home) -> "home_screen"
    contains(TaskyDeeplink.Host.login) -> "login_screen"
    contains(TaskyDeeplink.Host.reminder) -> {
        replace(TaskyDeeplink.SCHEME + TaskyDeeplink.Host.reminder, "reminder_screen")
    }
    else -> ""
}
