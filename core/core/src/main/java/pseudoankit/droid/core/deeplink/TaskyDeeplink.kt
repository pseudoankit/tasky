package pseudoankit.droid.core.deeplink

/**
 * Global deeplink file
 * Preferred way to create deeplink is via [pseudoankit.droid.navigation.deeplink.DeepLinkProvider]
 */
object TaskyDeeplink {
    object Path {
        object Reminder {
            const val action = "{action}"
        }
    }

    const val login = "tasky://login"
    const val registration = "tasky://registration"
    const val home = "tasky://home"
    const val reminder = "tasky://reminder/${Path.Reminder.action}"
    const val agendaSelection = "tasky://agendaSelection"
    const val profile = "tasky://profile"
}
