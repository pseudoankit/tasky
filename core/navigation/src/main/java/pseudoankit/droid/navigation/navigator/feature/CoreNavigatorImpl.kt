package pseudoankit.droid.navigation.navigator.feature

import android.content.Context
import androidx.navigation.NavController
import pseudoankit.droid.coreui.navigator.CoreNavigator
import pseudoankit.droid.coreui.util.extension.finish

internal class CoreNavigatorImpl(
    private val navController: NavController,
    private val context: Context
) : CoreNavigator {
    override fun navigateUp() {
        if (navController.popBackStack().not()) {
            context.finish()
        }
    }

    override fun showBackButton(): Boolean {
        return navController.backQueue.count() > 2
    }
}