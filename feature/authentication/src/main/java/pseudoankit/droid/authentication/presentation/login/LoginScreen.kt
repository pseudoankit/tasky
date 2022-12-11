package pseudoankit.droid.authentication.presentation.login

import androidx.compose.runtime.Composable
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig
import pseudoankit.droid.coreui.theme.TaskyDestinationSurface

@Composable
fun LoginScreen() {
    TaskyDestinationSurface(
        topBarConfig = TaskyTopBarConfig(
            title = "Welcome Back",
            leadingIcon = null
        )
    ) {

    }
}