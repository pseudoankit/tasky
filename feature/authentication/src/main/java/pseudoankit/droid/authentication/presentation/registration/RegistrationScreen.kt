package pseudoankit.droid.authentication.presentation.registration

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.authentication.di.RegistrationModule
import pseudoankit.droid.authentication.navigator.AuthNavigator
import pseudoankit.droid.authentication.presentation.registration.ui.RegistrationScreenComponents
import pseudoankit.droid.authentication.presentation.registration.ui.RegistrationScreenComponents.RegistrationInputFields
import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.coreui.util.extension.showToast
import pseudoankit.droid.unify.component.button.UnifyButton
import pseudoankit.droid.unify.component.button.UnifyButtonConfig
import pseudoankit.droid.unify.screen.UnifyScreen
import pseudoankit.droid.unify.screen.UnifyScreenConfig
import pseudoankit.droid.unify.token.UnifyDimens

@Destination
@Composable
internal fun RegistrationScreen(navigator: AuthNavigator) = RegistrationModule.load {
    val viewModel: RegistrationViewModel = getViewModel()

    viewModel.HandleSideEffect(navigator)

    UnifyScreen(
        config = UnifyScreenConfig(
            topBar = RegistrationScreenComponents.topBar(onEvent = viewModel::onEvent)
        ),
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(all = UnifyDimens.ScreenPadding)
    ) {
        val state = viewModel.collectAsState().value

        RegistrationInputFields(state = state, onEvent = viewModel::onEvent)

        Spacer(modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.height(12.dp))
        UnifyButton(
            config = UnifyButtonConfig(
                text = "Register",
                state = state.doneBtnState
            ),
            onClick = {
                viewModel.onEvent(RegistrationUiState.Event.OnRegisterUser)
            }
        )
    }
}

@Composable
private fun RegistrationViewModel.HandleSideEffect(navigator: AuthNavigator) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        container.sideEffectFlow.collectLatest {
            when (it) {
                RegistrationUiState.SideEffect.NavigateBack -> navigator.navigateUp()
                is RegistrationUiState.SideEffect.ShowErrorMessage -> context.showToast(it.message)
            }
        }
    }
}
