package pseudoankit.droid.app_shortcuts

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import pseudoankit.droid.core.deeplink.DeepLinkUtil
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.unify.utils.UnifyDrawable

object TaskyShortCutManager {

    fun initialize(context: Context) {
        addShortCut(
            context = context,
            id = "Reminder",
            label = "Add Reminder",
            icon = UnifyDrawable.ic_notification,
            navigationDeepLink = TaskyDeeplink.reminder
        )

/*        addShortCut(
            context = context,
            id = "Event",
            label = "Add Event",
            icon = UnifyDrawable.ic_calendar,
            navigationDeepLink = TaskyDeeplink.reminder
        )

        addShortCut(
            context = context,
            id = "Task",
            label = "Add Task",
            icon = UnifyDrawable.ic_task,
            navigationDeepLink = TaskyDeeplink.reminder
        )*/
    }

    private fun addShortCut(
        context: Context,
        id: String,
        label: String,
        longLabel: String = "",
        @DrawableRes icon: Int,
        navigationDeepLink: String
    ) {
        val shortcut = ShortcutInfoCompat.Builder(context, id)
            .setShortLabel(label)
            .setLongLabel(longLabel)
            .setIcon(IconCompat.createWithResource(context, icon))
            .setIntent(DeepLinkUtil.createDeeplinkIntent(navigationDeepLink))
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(context, shortcut)
    }
}