package pseudoankit.droid.navigation

import androidx.compose.runtime.Composable
import pseudoankit.droid.authentication.presentation.login.LoginScreen

@Composable
fun MainScreenNavigator(
    startDestination: String
) {

}

@Composable
fun NavigateToLogin() {
    LoginScreen()
}