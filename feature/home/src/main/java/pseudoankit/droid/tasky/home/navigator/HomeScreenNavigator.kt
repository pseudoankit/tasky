package pseudoankit.droid.tasky.home.navigator

import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

interface HomeScreenNavigator {
    fun navigateUp()
    fun navigateToAgendaItemsSelectorScreen()
    fun navigateToAgendaScreen(agendaTypes: AgendaTypes)
}