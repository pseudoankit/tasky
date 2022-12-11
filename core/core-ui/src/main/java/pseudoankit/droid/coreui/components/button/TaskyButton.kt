package pseudoankit.droid.coreui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import pseudoankit.droid.coreui.components.progressbar.TaskyProgressIndicator
import pseudoankit.droid.coreui.components.text.TaskyText
import pseudoankit.droid.coreui.components.text.TaskyTextConfig
import pseudoankit.droid.coreui.components.text.TaskyTextType
import pseudoankit.droid.coreui.token.TaskyColor
import pseudoankit.droid.coreui.token.TaskyDimens

@Composable
fun TaskyButton(config: TaskyButtonConfig) {
    Button(
        onClick = config.onClick,
        enabled = config.state == TaskyButtonConfig.State.Enabled,
        shape = RoundedCornerShape(TaskyDimens.Radius.Large),
        modifier = config.modifier
            .fillMaxWidth()
            .height(TaskyDimens.Dp_58),
        colors = when (config.state) {
            TaskyButtonConfig.State.Loading -> ButtonDefaults.buttonColors(
                containerColor = TaskyColor.Black,
                contentColor = TaskyColor.White
            )
            TaskyButtonConfig.State.Enabled -> ButtonDefaults.buttonColors(
                containerColor = TaskyColor.Black,
                contentColor = TaskyColor.White
            )
            TaskyButtonConfig.State.Disabled -> ButtonDefaults.buttonColors(
                containerColor = TaskyColor.Gray,
                contentColor = TaskyColor.DarkGray
            )
        }
    ) {
        if (config.state == TaskyButtonConfig.State.Loading) {
            TaskyProgressIndicator()
            return@Button
        }

        TaskyText(
            config = TaskyTextConfig(
                text = config.text,
                textType = TaskyTextType.LabelMedium
            )
        )
    }
}