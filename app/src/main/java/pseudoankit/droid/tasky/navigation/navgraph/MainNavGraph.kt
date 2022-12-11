package pseudoankit.droid.tasky.navigation.navgraph

import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import pseudoankit.droid.authentication.presentation.authenticationDestinations
import pseudoankit.droid.authentication.presentation.destinations.LoginScreenDestination

object MainNavGraph : NavGraphSpec {

    override val route: String = "Tasky"

    override val startRoute: Route = LoginScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>>
        get() = (
                authenticationDestinations
                ).associateBy { it.route }
}