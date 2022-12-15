package pseudoankit.droid.coreui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.components.button.UnifyButtonInternal.buttonColors
import pseudoankit.droid.coreui.components.button.UnifyButtonInternal.isEnabled
import pseudoankit.droid.coreui.components.button.UnifyButtonInternal.isLoading
import pseudoankit.droid.coreui.components.progressbar.UnifyProgressIndicator
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.token.UnifyDimens

object UnifyButton {
    data class Config(
        val text: String,
        val modifier: Modifier = Modifier,
        val onClick: () -> Unit,
        val state: State = State.Enabled
    )

    enum class State { Loading, Enabled, Disabled }

    fun Boolean.toUnifyButtonState(isLoading: Boolean = false) = when (isLoading) {
        true -> State.Loading
        false -> when {
            this -> State.Enabled
            else -> State.Disabled
        }
    }
}

@Composable
fun UnifyButton(config: UnifyButton.Config) {
    Button(
        onClick = config.onClick,
        enabled = config.state.isEnabled,
        shape = RoundedCornerShape(UnifyDimens.Radius.Large),
        modifier = config.modifier
            .fillMaxWidth()
            .height(UnifyDimens.Dp_58),
        colors = config.state.buttonColors()
    ) {
        if (config.state.isLoading) {
            UnifyProgressIndicator()
            return@Button
        }

        UnifyTextView(
            config = UnifyTextView.Config(
                text = config.text,
                textType = UnifyTextType.LabelMedium
            )
        )
    }
}
