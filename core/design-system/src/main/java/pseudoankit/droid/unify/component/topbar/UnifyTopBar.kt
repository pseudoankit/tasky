package pseudoankit.droid.unify.component.topbar

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.DarkThemeRipple

object UnifyTopBar {

    @Composable
    operator fun invoke(config: Config?) {
        if (config == null) return

        // changing ripple color for black background
        CompositionLocalProvider(LocalRippleTheme provides DarkThemeRipple) {
            when (config.type) {
                Type.Small -> UnifySmallTopBar(config)
            }
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
        val text: UnifyTextView.Config? = null,
        val icon: UnifyIcon.Config? = null,
        val modifier: Modifier = Modifier,
        val onClick: (() -> Unit)? = null
    )

    enum class Type { Small }
}
