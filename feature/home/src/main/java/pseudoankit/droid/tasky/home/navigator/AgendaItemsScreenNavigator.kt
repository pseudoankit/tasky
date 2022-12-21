package pseudoankit.droid.tasky.home.navigator

import pseudoankit.droid.coreui.navigator.CoreNavigator

interface AgendaItemsScreenNavigator : CoreNavigator {
    fun navigateToReminder()
    fun navigateToTasks()
    fun navigateToEvents()
}