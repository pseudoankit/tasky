package pseudoankit.droid.coreui.components.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.components.icon.TaskyIcon
import pseudoankit.droid.coreui.components.icon.TaskyIconButton
import pseudoankit.droid.coreui.components.text.TaskyText
import pseudoankit.droid.coreui.components.text.TaskyTextConfig
import pseudoankit.droid.coreui.components.text.TaskyTextType
import pseudoankit.droid.coreui.token.TaskyDimens

@Composable
fun TaskyTopBar(config: TaskyTopBarConfig) {
    when (config.type) {
        TaskyTopBarConfig.Type.Small -> SmallTopBar(config = config)
    }
}

@Composable
private fun SmallTopBar(config: TaskyTopBarConfig) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(TaskyDimens.Dp_64)
            .padding(TaskyDimens.ScreenPadding)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
            TaskyIconButton(
                config.leadingIcon?.copy(
                    tint = config.tintColor
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            config.trailingSection?.apply {
                Row(
                    modifier = modifier,
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TaskyIcon(config = icon?.copy(tint = config.tintColor))
                    Spacer(modifier = Modifier.width(TaskyDimens.Dp_4))
                    TaskyText(config = text?.copy(color = config.tintColor))
                }
            }
        }

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            TaskyText(
                config = TaskyTextConfig(
                    text = config.title,
                    textType = TaskyTextType.TitleLarge,
                    color = config.tintColor
                )
            )
        }
    }
}