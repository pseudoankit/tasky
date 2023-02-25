package pseudoankit.droid.unify.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pseudoankit.droid.unify.component.button.UnifyButtonMapper.buttonColors
import pseudoankit.droid.unify.component.button.UnifyButtonMapper.isEnabled
import pseudoankit.droid.unify.component.button.UnifyButtonMapper.isLoading
import pseudoankit.droid.unify.component.progressbar.UnifyProgressIndicator
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyTokens

object UnifyButton {

    @Composable
    operator fun invoke(config: Config) {
        Button(
            onClick = config.onClick,
            enabled = config.state.isEnabled,
            shape = RoundedCornerShape(UnifyTokens.Button.Radius),
            modifier = config.modifier
                .fillMaxWidth()
                .height(UnifyTokens.Button.Height),
            colors = config.state.buttonColors()
        ) {
            if (config.state.isLoading) {
                UnifyProgressIndicator()
                return@Button
            }
            UnifyTextView(
                config = UnifyTextView.Config(
                    text = config.text,
                    textType = UnifyTokens.Button.TextType
                )
            )
        }
    }

    data class Config(
        val text: String,
        val modifier: Modifier = Modifier,
        val onClick: () -> Unit,
        val state: State = State.Enabled
    )

    enum class State {
        Loading, Enabled, Disabled;

        companion object {
            fun fromBoolean(isValid: Boolean, isLoading: Boolean = false) = when (isLoading) {
                true -> Loading
                false -> when (isValid) {
                    true -> Enabled
                    false -> Disabled
                }
            }
        }
    }
}