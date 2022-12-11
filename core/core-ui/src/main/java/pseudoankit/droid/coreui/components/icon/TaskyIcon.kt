package pseudoankit.droid.coreui.components.icon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.coreui.token.TaskyDimens

data class TaskyIconConfig(
    val icon: TaskyIcons,
    val modifier: Modifier = Modifier,
    val contentDescription: String = "",
    val tint: Color = Color.Black,
    val size: Dp = TaskyDimens.Dp_30,
    val onClick: (() -> Unit)? = null
)

@Composable
fun TaskyIcon(config: TaskyIconConfig?) {
    if (config == null) return

    val iconModifier = config.modifier
        .size(config.size)
        .clip(CircleShape)
        .clickable(enabled = config.onClick != null) {
            config.onClick?.invoke()
        }

    when (config.icon.iconType) {
        is TaskyIcons.IconTypes.Vector -> Icon(
            imageVector = config.icon.iconType.imageVector,
            contentDescription = config.contentDescription,
            modifier = iconModifier,
            tint = config.tint
        )
    }
}