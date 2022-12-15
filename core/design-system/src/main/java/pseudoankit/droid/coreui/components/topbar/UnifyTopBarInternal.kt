package pseudoankit.droid.coreui.components.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.token.UnifyDimens

internal object UnifyTopBarInternal {

    @Composable
    fun UnifyTopBar.Config.SmallTopBar() {
        val config = this

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
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        UnifyIcon(config = icon?.copy(tint = config.tintColor))
                        Spacer(modifier = Modifier.width(UnifyDimens.Dp_4))
                        UnifyTextView(config = text?.copy(color = config.tintColor))
                    }
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
}