package pseudoankit.droid.navigation.navgraph

import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import pseudoankit.droid.authentication.presentation.authenticationDestinations
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination
import pseudoankit.droid.tasky.home.presentation.homeDestinations
import pseudoankit.droid.tasky.reminder.presentation.ui.destinations.ReminderScreenDestination

fun mainNavGraph(isUserLoggedIn: Boolean) = object : NavGraphSpec {
    override val route: String = "Tasky"

    override val startRoute: Route =
        if (isUserLoggedIn) HomeScreenDestination else LoginScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>>
        get() = destinations.associateBy {
            it.route
        }

    private val destinations
        get() = authenticationDestinations
            .plus(homeDestinations)
            .plus(ReminderScreenDestination)
}