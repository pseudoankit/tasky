package pseudoankit.droid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.presentation.login.LoginScreen
import pseudoankit.droid.navigation.util.constant.Routes

@Composable
fun MainScreenNavigator(
    startDestination: String,
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.Login) {
            LoginModule.load()
            LoginScreen()
        }
    }
}
