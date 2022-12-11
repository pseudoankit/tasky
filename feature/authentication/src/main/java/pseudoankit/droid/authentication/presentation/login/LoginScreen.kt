package pseudoankit.droid.authentication.presentation.login

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.components.textfield.TaskyTextField
import pseudoankit.droid.coreui.components.textfield.TaskyTextFieldConfig
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig
import pseudoankit.droid.coreui.theme.TaskyDestinationSurface

@Composable
fun LoginScreen() {
    TaskyDestinationSurface(
        topBarConfig = TaskyTopBarConfig(
            title = "Welcome Back",
            leadingIcon = null
        ),
    ) {
        LoginScreenInternal()
    }
}

@Composable
private fun LoginScreenInternal(
    viewModel: LoginViewModel = getViewModel()
) {
    val state = viewModel.state.value

    TaskyTextField(
        config = TaskyTextFieldConfig(
            value = state.email,
            onValueChange = viewModel::onEmailValueChanged
        )
    )
}