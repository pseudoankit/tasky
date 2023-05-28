package pseudoankit.droid.app_widgets.agenda_items

import kotlinx.serialization.Serializable

@Serializable
data class WidgetAgendaItem(
    val id: Long,
    val title: String
)
