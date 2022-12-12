package pseudoankit.droid.coreui.components.icon

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.coreui.token.UnifyDimens

object UnifyIcon {
    data class Config(
        val icon: UnifyIcons,
        val modifier: Modifier = Modifier,
        val contentDescription: String = "",
        val tint: Color = Color.Black,
        val size: Dp = UnifyDimens.Dp_30,
        val onClick: (() -> Unit)? = null
    )
}

@Composable
fun UnifyIcon(config: UnifyIcon.Config?) {
    if (config == null) return

    val iconModifier = config.modifier
        .size(config.size)
        .clip(CircleShape)

    when (config.icon.iconType) {
        is UnifyIcons.IconTypes.Vector -> Icon(
            imageVector = config.icon.iconType.imageVector,
            contentDescription = config.contentDescription,
            modifier = iconModifier,
            tint = config.tint
        )
    }
}

@Composable
fun UnifyIconButton(config: UnifyIcon.Config?) {
    if (config == null) return

    IconButton(onClick = { config.onClick?.invoke() }) {
        UnifyIcon(config = config)
    }
}