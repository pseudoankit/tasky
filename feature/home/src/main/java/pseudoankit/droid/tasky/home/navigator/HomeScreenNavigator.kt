package pseudoankit.droid.tasky.home.navigator

import pseudoankit.droid.agendamanger.domain.model.AgendaItem

interface HomeScreenNavigator {
    fun navigateUp()
    fun navigateToAgendaItemsSelectorScreen()
    fun navigateToAgendaScreen(agendaItem: AgendaItem)
}