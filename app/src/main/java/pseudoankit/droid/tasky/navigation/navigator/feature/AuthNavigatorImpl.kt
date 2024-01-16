package pseudoankit.droid.tasky.navigation.navigator.feature

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.authentication.presentation.destinations.RegistrationScreenDestination

internal class AuthNavigatorImpl(
    private val navController: NavController,
    private val context: Context
) : AuthNavigator {

    override fun navigateUp() {
        // overridden in CoreNavigatorImpl
    }

    override fun navigateToHomeScreen() {
        // overridden in CoreNavigatorImpl
    }

    override fun navigateToRegistrationScreen() {
        navController.navigate(RegistrationScreenDestination)
    }
}