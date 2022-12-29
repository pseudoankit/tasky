package pseudoankit.droid.tasky.navigation.navigator.feature

import android.content.Context
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.destinations.AgendaItemsScreenDestination
import pseudoankit.droid.tasky.navigation.navigator.CoreNavigatorImpl

internal class HomeScreenNavigatorImpl(
    private val navController: NavController,
    private val context: Context
) : HomeScreenNavigator, CoreNavigator by CoreNavigatorImpl(navController, context) {

    override fun navigateToAgendaItemsScreen() {
        navController.navigate(AgendaItemsScreenDestination)
    }
}