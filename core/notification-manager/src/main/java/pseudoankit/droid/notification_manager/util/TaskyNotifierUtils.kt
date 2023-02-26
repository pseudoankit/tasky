package pseudoankit.droid.notification_manager.util

import pseudoankit.droid.notification_manager.TaskyNotifierConfig
import pseudoankit.droid.unify.utils.UnifyDrawable

internal object TaskyNotifierUtils {

    val TaskyNotifierConfig.Source.smallIcon get() = when(this) {
        TaskyNotifierConfig.Source.Reminder -> UnifyDrawable.ic_notification
        TaskyNotifierConfig.Source.Task -> UnifyDrawable.ic_notification
        TaskyNotifierConfig.Source.Event -> UnifyDrawable.ic_notification
    }
}