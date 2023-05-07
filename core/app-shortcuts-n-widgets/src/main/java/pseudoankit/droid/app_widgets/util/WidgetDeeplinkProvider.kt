package pseudoankit.droid.app_widgets.util

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

interface WidgetDeeplinkProvider {
    fun agendaDetailRoute(action: AgendaTypes): String
}
