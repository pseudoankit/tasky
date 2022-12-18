package pseudoankit.droid.authentication.navigator

import pseudoankit.droid.coreui.navigator.CoreNavigator

interface AuthNavigator : CoreNavigator {
    fun navigateToRegistrationScreen()
    fun navigateToHome()
}