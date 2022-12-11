package pseudoankit.droid.coreui.components.icon

import androidx.compose.ui.Modifier
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