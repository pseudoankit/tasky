package pseudoankit.droid.core.deeplink

/**
 * Global deeplink file
 * Preferred way to create deeplink is via [pseudoankit.droid.navigation.deeplink.DeepLinkProvider]
 */
object TaskyDeeplink {
    const val login = "tasky://home"
    const val home = "tasky://home"
    const val reminder = "tasky://reminder/${ReminderArgs.ACTION}"

    object ReminderArgs {
        const val ACTION = "{action}"
    }
}