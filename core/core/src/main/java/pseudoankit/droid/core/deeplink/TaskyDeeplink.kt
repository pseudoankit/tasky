package pseudoankit.droid.core.deeplink

object TaskyDeeplink {
    const val login = "tasky://home"
    const val home = "tasky://home"
    const val reminder = "tasky://reminder/${ReminderArgs.ACTION}"

    object ReminderArgs {
        const val ACTION = "{action}"
    }
}