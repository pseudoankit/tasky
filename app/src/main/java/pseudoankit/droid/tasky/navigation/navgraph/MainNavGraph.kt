package pseudoankit.droid.tasky.navigation.navgraph

import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import pseudoankit.droid.authentication.presentation.authenticationDestinations
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination
import pseudoankit.droid.tasky.home.presentation.destinations.HomeScreenDestination

object MainNavGraph : NavGraphSpec {

    override val route: String = "Tasky"

    override val startRoute: Route = LoginScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>>
        get() = destinations.associateBy { it.route }

    private val destinations get() = authenticationDestinations + HomeScreenDestination
}