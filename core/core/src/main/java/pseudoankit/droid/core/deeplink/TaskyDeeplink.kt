package pseudoankit.droid.core.deeplink

/**
 * Global deeplink file
 * Preferred way to create deeplink is via [pseudoankit.droid.navigation.deeplink.DeepLinkProvider]
 */
object TaskyDeeplink {
    const val SCHEME = "tasky://"

    object Host {
        const val login = "login"
        const val home = "home"
        const val reminder = "reminder"
    }

    object Path {
        object Reminder {
            const val ACTION = "{action}"
        }
    }

    const val login = "${SCHEME}${Host.login}"
    const val home = "${SCHEME}${Host.home}"
    const val reminder = "${SCHEME}${Host.reminder}/${Path.Reminder.ACTION}"


    fun mapToInternalRoute(externalLink: String) = externalLink.run {
        when {
            contains(Host.home) -> "home_screen"
            contains(Host.login) -> "login_screen"
            contains(Host.reminder) -> {
                replace(SCHEME + Host.reminder, "reminder_screen")
            }
            else -> ""
        }
    }
}
