package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import pseudoankit.droid.authentication.di.LoginModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.topbar.UnifyTopBar
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface

@Destination
@Composable
fun RegistrationScreen(
    navigator: AuthNavigator
) {
    TaskyDestinationSurface(
        topBarConfig = UnifyTopBar.Config(
            title = "Create your account",
            leadingIcon = if (navigator.showBackButton()) {
                UnifyIcon.Config(icon = UnifyIcons.Back)
            } else null
        ),
        module = LoginModule,
        singleEvents = {

        }
    ) {

    }
}