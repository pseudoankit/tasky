package pseudoankit.droid.coreui.components.progressbar

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.coreui.token.TaskyColor
import pseudoankit.droid.coreui.token.TaskyDimens

data class TaskyProgressIndicatorConfig(
    val type: Type = Type.Circular,
    val modifier: Modifier = Modifier,
    val color: Color = TaskyColor.Unspecified,
    val strokeWidth: Dp = TaskyDimens.Dp_4
) {

    enum class Type {
        Circular
    }
}

@Composable
fun TaskyProgressIndicator(config: TaskyProgressIndicatorConfig = TaskyProgressIndicatorConfig()) {
    when (config.type) {
        TaskyProgressIndicatorConfig.Type.Circular -> CircularProgressIndicator(
            modifier = config.modifier,
            color = config.color,
            strokeWidth = config.strokeWidth
        )
    }
}