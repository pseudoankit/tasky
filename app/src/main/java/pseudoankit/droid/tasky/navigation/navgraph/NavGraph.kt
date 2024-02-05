package pseudoankit.droid.tasky.navigation.navgraph

import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import pseudoankit.droid.authentication.presentation.authenticationDestinations
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.home.presentation.homeDestinations
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderScreenDestination

object NavGraph {

    private val auth = object : NavGraphSpec {
        override val destinationsByRoute: Map<String, DestinationSpec<*>> =
            authenticationDestinations
                .associateBy { it.route }
        override val route: String = "auth"
        override val startRoute: Route = LoginScreenDestination
    }

    private val main = object : NavGraphSpec {
        override val destinationsByRoute: Map<String, DestinationSpec<*>> =
            homeDestinations
                .plus(ReminderScreenDestination)
                .associateBy { it.route }
        override val route: String = "main"
        override val startRoute: Route = HomeScreenDestination
    }

    fun root(isUserLoggedIn: Boolean) = object : NavGraphSpec {
        override val destinationsByRoute: Map<String, DestinationSpec<*>> = emptyMap()
        override val route: String = "root"
        override val startRoute: Route = if (isUserLoggedIn) main else auth
        override val nestedNavGraphs: List<NavGraphSpec> = listOf(
            auth, main
        )
    }
}