package pseudoankit.droid.unify.components.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors

object UnifyTopBar {

    @Composable
    operator fun invoke(config: Config?) {
        if (config == null) return

        when (config.type) {
            Type.Small -> UnifySmallTopBar(config)
        }
    }

    data class Config(
        val leadingIcon: UnifyIcon.Config? = null,
        val title: String = "",
        val type: Type = Type.Small,
        val trailingSection: TrailingSection? = null,
        val tintColor: Color = UnifyColors.White
    )

    data class TrailingSection(
        val text: UnifyTextView.Config?,
        val icon: UnifyIcon.Config?,
        val modifier: Modifier = Modifier
    )

    enum class Type { Small }
}
