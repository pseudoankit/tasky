package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.components.icon.TaskyIconConfig
import pseudoankit.droid.coreui.components.icon.TaskyIcons
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig
import pseudoankit.droid.coreui.token.TaskyDestinationSurface

@Destination
@Composable
fun RegistrationScreen(
    navigator: AuthNavigator
) {
    TaskyDestinationSurface(
        topBarConfig = TaskyTopBarConfig(
            title = "Create your account",
            leadingIcon = if (navigator.showBackButton()) {
                TaskyIconConfig(icon = TaskyIcons.Back)
            } else null
        ),
        module = LoginModule,
        singleEvents = {

        }
    ) {

    }
}