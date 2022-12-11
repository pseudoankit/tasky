package pseudoankit.droid.tasky.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.navigator.LoginNavigator
import pseudoankit.droid.authentication.presentation.destinations.RegistrationScreenDestination
import pseudoankit.droid.core.util.finish

class MainNavigator(
    private val navController: NavController,
    private val context: Context
) : LoginNavigator {

    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }

    override fun showBackButton(): Boolean {
        return navController.backQueue.isEmpty().not()
    }

    override fun navigateToRegistrationScreen() {
        navController.navigate(RegistrationScreenDestination)
    }

    override fun navigateToHome() {

    }
}