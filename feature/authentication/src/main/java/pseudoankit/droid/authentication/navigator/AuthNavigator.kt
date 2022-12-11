package pseudoankit.droid.authentication.navigator

interface AuthNavigator {
    fun navigateToRegistrationScreen()
    fun navigateToHome()
    fun navigateUp()
    fun showBackButton(): Boolean
}