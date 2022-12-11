package pseudoankit.droid.coreui.components.icon

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip

@Composable
fun TaskyIcon(config: TaskyIconConfig?) {
    if (config == null) return

    val iconModifier = config.modifier
        .size(config.size)
        .clip(CircleShape)

    when (config.icon.iconType) {
        is TaskyIcons.IconTypes.Vector -> Icon(
            imageVector = config.icon.iconType.imageVector,
            contentDescription = config.contentDescription,
            modifier = iconModifier,
            tint = config.tint
        )
    }
}

@Composable
fun TaskyIconButton(config: TaskyIconConfig?) {
    if (config == null) return

    IconButton(onClick = { config.onClick?.invoke() }) {
        TaskyIcon(config = config)
    }
}