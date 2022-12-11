package pseudoankit.droid.coreui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import pseudoankit.droid.coreui.components.topbar.TaskyTopBar
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig
import pseudoankit.droid.coreui.util.TaskyColor
import pseudoankit.droid.coreui.util.TaskyDimens
import pseudoankit.droid.coreui.util.TaskyTheme

@Composable
fun TaskyDestinationSurface(
    topBarConfig: TaskyTopBarConfig,
    content: @Composable () -> Unit
) {
    TaskyTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = TaskyColor.Black)
            ) {
                TaskyTopBar(config = topBarConfig)
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = TaskyDimens.Radius.Large,
                                topEnd = TaskyDimens.Radius.Large
                            )
                        ),
                    color = TaskyColor.White
                ) {
                    Box(modifier = Modifier.padding(TaskyDimens.ScreenPadding)) {
                        content()
                    }
                }
            }
        }
    }
}