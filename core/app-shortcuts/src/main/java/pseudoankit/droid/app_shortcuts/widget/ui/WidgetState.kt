package pseudoankit.droid.app_shortcuts.widget.ui

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import pseudoankit.droid.agendamanger.domain.model.AgendaItem

data class WidgetState(
    val items: ImmutableList<AgendaItem> = persistentListOf()
)