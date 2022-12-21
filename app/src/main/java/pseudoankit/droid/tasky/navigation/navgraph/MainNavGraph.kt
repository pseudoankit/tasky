package pseudoankit.droid.tasky.navigation.navgraph

import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import pseudoankit.droid.authentication.presentation.authenticationDestinations
import pseudoankit.droid.tasky.home.presentation.ui.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderHomeScreenDestination

object MainNavGraph : NavGraphSpec {

    override val route: String = "Tasky"

    // todo changed start for now
    override val startRoute: Route = HomeScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>>
        get() = destinations.associateBy {
            it.route
        }

    private val destinations get() = authenticationDestinations + HomeScreenDestination + ReminderHomeScreenDestination
}