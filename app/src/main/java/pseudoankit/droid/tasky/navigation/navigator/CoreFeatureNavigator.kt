package pseudoankit.droid.tasky.navigation.navigator

import android.content.Context
import androidx.navigation.NavController
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.coreui.util.extension.finish
import pseudoankit.droid.tasky.home.navigator.AgendaItemsScreenNavigator
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.navigation.navigator.feature.AgendaItemsScreenNavigatorImpl
import pseudoankit.droid.tasky.navigation.navigator.feature.AuthNavigatorImpl
import pseudoankit.droid.tasky.navigation.navigator.feature.HomeScreenNavigatorImpl

internal class CoreFeatureNavigator(
    private val navController: NavController,
    private val context: Context
) : AuthNavigator by AuthNavigatorImpl(navController, context),
    HomeScreenNavigator by HomeScreenNavigatorImpl(navController, context),
    AgendaItemsScreenNavigator by AgendaItemsScreenNavigatorImpl(navController, context),
    CoreNavigator {

    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }

    override fun showBackButton(): Boolean {
        return navController.backQueue.count() > 2
    }
}