package pseudoankit.droid.unify.component.topbar

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.DarkThemeRipple

@Composable
fun UnifyTopBar(config: UnifyTopBarConfig?) {
    if (config == null) return

    // changing ripple color for black background
    CompositionLocalProvider(LocalRippleTheme provides DarkThemeRipple) {
        when (config.type) {
            UnifyTopBarConfig.Type.Small -> UnifySmallTopBar(config)
        }
    }
}

data class UnifyTopBarConfig(
    val leadingIcon: UnifyIconConfig? = null,
    val title: String = "",
    val type: Type = Type.Small,
    val trailingSection: TrailingSection? = null,
    val tintColor: Color = UnifyColors.White
) {

    data class TrailingSection(
        val text: UnifyTextViewConfig? = null,
        val icon: UnifyIconConfig? = null,
        val modifier: Modifier = Modifier,
        val onClick: (() -> Unit)? = null
    )

    enum class Type { Small }
}
