package pseudoankit.droid.authentication.navigator

import pseudoankit.droid.core.navigator.CoreNavigator

interface AuthNavigator : CoreNavigator {
    fun navigateToRegistrationScreen()
    fun navigateToHome()
}