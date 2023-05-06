package pseudoankit.droid.app_shortcuts.widget.util

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.extension.parseToString

val AgendaItem.displayDateTime: String?
    get() = when (this) {
        is AgendaItem.Event -> null
        is AgendaItem.Reminder -> "${date.parseToString("dd MMM")}, ${
            when (time) {
                AgendaItem.Reminder.Time.AllDay -> null
                is AgendaItem.Reminder.Time.Time -> {
                    (time as? AgendaItem.Reminder.Time.Time)?.value.parseToString()
                }
            }
        }"
        is AgendaItem.Task -> null
    }