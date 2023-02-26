package pseudoankit.droid.core.deeplink

object TaskyDeeplink {
    const val home = "tasky://home"

    object Reminder {
        const val ARG_ACTION = "{action}"

        const val route = "tasky://reminder/${ARG_ACTION}"
    }
}