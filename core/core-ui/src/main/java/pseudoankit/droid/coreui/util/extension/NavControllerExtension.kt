package pseudoankit.droid.coreui.util.extension

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

fun NavController.clearStack(navOptionsBuilder: NavOptionsBuilder) {
    navOptionsBuilder.popUpTo(this.graph.id) {
        inclusive = true
    }
}

fun NavController.clearStack() {
    popBackStack(this.graph.id, true)
}