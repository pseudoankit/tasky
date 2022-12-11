package pseudoankit.droid.coreui.components.button

import androidx.compose.ui.Modifier

data class TaskyButtonConfig(
    val text: String,
    val modifier: Modifier = Modifier,
    val onClick: () -> Unit,
    val state: State = State.Enabled
) {

    enum class State {
        Loading, Enabled, Disabled;
    }
}

val Boolean.toTaskyButtonState get() = if (this) TaskyButtonConfig.State.Enabled else TaskyButtonConfig.State.Disabled