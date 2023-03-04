package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.authentication.di.RegistrationModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.topbar.UnifyTopBar
import pseudoankit.droid.unify.component.topbar.UnifyTopBarConfig
import pseudoankit.droid.unify.screen.UnifyScreen
import pseudoankit.droid.unify.screen.UnifyScreenConfig

@Destination
@Composable
internal fun RegistrationScreen(navigator: AuthNavigator) = RegistrationModule.load {
    val viewModel: RegistrationViewModel = getViewModel()

    UnifyScreen(
        config = UnifyScreenConfig(
            topBar = UnifyTopBarConfig(
                title = "Create your account",
                leadingIcon = UnifyIconConfig(
                    icon = UnifyIcons.Back,
                    onClick = viewModel::navigateBack
                )
            )
        ),
        singleEvents = {
            viewModel.container.sideEffectFlow.collectLatest {
                when (it) {
                    RegistrationUiState.SideEffect.NavigateBack -> navigator.navigateUp()
                }
            }
        }
    ) {

    }
}