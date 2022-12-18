package pseudoankit.droid.coreui.components.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.components.topbar.UnifyTopBarInternal.SmallTopBar
import pseudoankit.droid.coreui.token.UnifyColors

object UnifyTopBar {
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

@Composable
fun UnifyTopBar(config: UnifyTopBar.Config?) {
    if (config == null) return

    when (config.type) {
        UnifyTopBar.Type.Small -> config.SmallTopBar()
    }
}
