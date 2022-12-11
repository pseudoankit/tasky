package pseudoankit.droid.tasky.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.navigator.LoginNavigator
import pseudoankit.droid.authentication.presentation.destinations.RegistrationScreenDestination

class MainNavigator(
    private val navController: NavController,
    private val context: Context
) : LoginNavigator {

    override fun navigateToRegistrationScreen() {
        navController.navigate(RegistrationScreenDestination)
    }

    override fun navigateToHome() {

    }
}