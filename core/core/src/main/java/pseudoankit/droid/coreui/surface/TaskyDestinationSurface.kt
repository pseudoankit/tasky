package pseudoankit.droid.coreui.surface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlinx.coroutines.CoroutineScope
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.coreui.components.topbar.UnifyTopBar
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens
import pseudoankit.droid.coreui.token.UnifyTheme

@Composable
fun TaskyDestinationSurface(
    topBarConfig: UnifyTopBar.Config,
    singleEvents: suspend CoroutineScope.() -> Unit = {},
    module: BaseKoinModule? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    DisposableEffect(Unit) {
        onDispose {
            module?.unload()
        }
    }

    LaunchedEffect(key1 = Unit, block = singleEvents)

    UnifyTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = UnifyColors.Black)
            ) {
                UnifyTopBar(config = topBarConfig)
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = UnifyDimens.Radius.Large,
                                topEnd = UnifyDimens.Radius.Large
                            )
                        ),
                    color = UnifyColors.White
                ) {
                    Column(modifier = Modifier.padding(UnifyDimens.ScreenPadding)) {
                        content()
                    }
                }
            }
        }
    }
}