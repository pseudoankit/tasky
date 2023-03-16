package pseudoankit.droid.app_shortcuts

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import pseudoankit.droid.core.deeplink.TaskyDeeplink

object ShortCutManager {

    fun initialize(context: Context) {
        addShortCut(
            context = context,
            id = "Reminder",
            label = "Add Reminder",
            icon = R.drawable.baseline_notifications_24,
            navigationDeepLink = TaskyDeeplink.reminder
        )
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
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse(navigationDeepLink)))
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(context, shortcut)
    }
}