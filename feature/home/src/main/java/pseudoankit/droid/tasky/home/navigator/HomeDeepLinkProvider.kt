package pseudoankit.droid.tasky.home.navigator

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

interface HomeDeepLinkProvider {
    fun agendaRoute(action: AgendaTypes.Action): String
}