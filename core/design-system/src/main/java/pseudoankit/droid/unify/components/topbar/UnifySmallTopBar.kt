package pseudoankit.droid.unify.components.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyDimens
import pseudoankit.droid.unify.utils.clickable

internal object UnifySmallTopBar {

    @Composable
    operator fun invoke(config: UnifyTopBar.Config) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(UnifyDimens.Dp_64)
                .padding(UnifyDimens.ScreenPadding)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
                UnifyIcon(config.leadingIcon?.copy(tint = config.tintColor))
                Spacer(modifier = Modifier.weight(1f))
                config.trailingSection?.apply {
                    TrailingSection(tintColor = config.tintColor)
                }
            }

            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                UnifyTextView(
                    config = UnifyTextView.Config(
                        text = config.title,
                        textType = UnifyTextType.TitleLarge,
                        color = config.tintColor
                    )
                )
            }
        }
    }

    @Composable
    private fun UnifyTopBar.TrailingSection.TrailingSection(tintColor: Color) {
        when {
            icon != null && text != null -> {
                Row(
                    modifier = modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(UnifyDimens.Radius.XSmall))
                        .clickable(onClick = onClick)
                        .padding(horizontal = UnifyDimens.Dp_8),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UnifyIcon(config = icon.copy(tint = tintColor))
                    Spacer(modifier = Modifier.width(UnifyDimens.Dp_4))
                    UnifyTextView(config = text.copy(color = tintColor))
                }
            }
            text != null -> {
                UnifyTextView(
                    config = text.copy(
                        color = tintColor,
                        modifier = modifier
                            .clip(RoundedCornerShape(UnifyDimens.Radius.XSmall))
                            .clickable(onClick = onClick)
                            .padding(horizontal = UnifyDimens.Dp_8, vertical = UnifyDimens.Dp_4),
                        textType = UnifyTextType.TitleMedium
                    )
                )
            }
            icon != null -> {
                UnifyIcon(config = icon.copy(tint = tintColor, onClick = onClick))
            }
            else -> {}
        }
    }
}