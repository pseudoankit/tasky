package pseudoankit.droid.tasky.home.navigator

import pseudoankit.droid.coreui.navigator.CoreNavigator

interface HomeNavigator : CoreNavigator {
    fun navigateToReminder()
    fun navigateToTasks()
    fun navigateToEvents()
}