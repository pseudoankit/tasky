package pseudoankit.droid.tasky.home.domain.model

import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.components.icon.UnifyIcons

enum class AgendaType {
    Reminder, Task, Event;

    val label
        get() = when (this) {
            Reminder -> TextResource.WithText(Reminder.name)
            Task -> TextResource.WithText(Task.name)
            Event -> TextResource.WithText(Event.name)
        }

    val icon
        get() = when (this) {
            Reminder -> UnifyIcons.Bell
            Task -> UnifyIcons.Tasks
            Event -> UnifyIcons.Calendar
        }
}