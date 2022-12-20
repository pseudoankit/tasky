package pseudoankit.droid.unify.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pseudoankit.droid.unify.components.button.UnifyButtonMapper.buttonColors
import pseudoankit.droid.unify.components.button.UnifyButtonMapper.isEnabled
import pseudoankit.droid.unify.components.button.UnifyButtonMapper.isLoading
import pseudoankit.droid.unify.components.progressbar.UnifyProgressIndicator
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyDimens

object UnifyButton {

    @Composable
    operator fun invoke(config: Config) {
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
                    textType = UnifyTextType.TitleMedium
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