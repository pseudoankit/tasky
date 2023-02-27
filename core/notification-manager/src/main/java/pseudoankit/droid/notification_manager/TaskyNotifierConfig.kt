package pseudoankit.droid.notification_manager

import java.util.Random

data class TaskyNotifierConfig(
    val notificationId: Int = Random().nextInt(),
    val source: Source,
    val title: String = source.name,
    val description: String,
    val priority: Priority = Priority.Default,
    val navigationUrl: String,
) {

    enum class Priority(
        internal val priority: Int,
        internal val importance: Int,
    ) {
        Default(priority = 0, importance = 3),
        Low(priority = -1, importance = 2),
        Min(priority = -2, importance = 1),
        High(priority = 1, importance = 4),
        Max(priority = 2, importance = 5)
    }

    enum class Source {
        Reminder,
        Task,
        Event
    }
}
