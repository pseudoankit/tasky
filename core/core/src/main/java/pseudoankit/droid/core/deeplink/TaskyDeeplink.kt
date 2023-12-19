package pseudoankit.droid.core.deeplink

/**
 * Global deeplink file
 * Preferred way to create deeplink is via [pseudoankit.droid.navigation.deeplink.DeepLinkProvider]
 */
object TaskyDeeplink {
    private const val SCHEME = "tasky://"

    private object Host {
        const val registration = "registration"
        const val login = "login"
        const val home = "home"
        const val reminder = "reminder"
        const val agendaSelection = "agendaSelection"
    }

    object Path {
        object Reminder {
            const val action = "{action}"
        }
    }

    const val login = "${SCHEME}${Host.login}"
    const val registration = "${SCHEME}${Host.registration}"
    const val home = "${SCHEME}${Host.home}"
    const val reminder = "${SCHEME}${Host.reminder}/${Path.Reminder.action}"
    const val agendaSelection = "${SCHEME}${Host.agendaSelection}"
}
