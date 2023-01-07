package pseudoankit.droid.coreui.surface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlinx.coroutines.CoroutineScope
import pseudoankit.droid.unify.components.topbar.UnifyTopBar
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens
import pseudoankit.droid.unify.token.UnifyTheme

/**
 * @param[topBar] for custom topBars
 */
data class TaskyDestinationSurfaceConfig(
    val topBar: @Composable BoxScope.() -> Unit,
    val floatingActionButton: @Composable () -> Unit = {}
) {

    /**
     * @param[topBar] topBar or actionBar configs
     */
    constructor(
        topBar: UnifyTopBar.Config? = null,
        floatingActionButton: @Composable () -> Unit = {},
    ) : this(
        topBar = {
            UnifyTopBar(topBar)
        },
        floatingActionButton = floatingActionButton,
    )
}

/**
 * Helper method to configure repeating logic for any destination
 * @param[content] actual composable content of screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskyDestinationSurface(
    config: TaskyDestinationSurfaceConfig,
    singleEvents: (suspend CoroutineScope.() -> Unit)? = null,
    padding: PaddingValues = PaddingValues(all = UnifyDimens.ScreenPadding),
    content: @Composable ColumnScope.() -> Unit,
) = with(config) {
    if (singleEvents != null) {
        LaunchedEffect(key1 = Unit, block = singleEvents)
    }

    UnifyTheme {
        Scaffold(
            topBar = {
                Box(content = topBar)
            },
            containerColor = UnifyColors.Black,
            floatingActionButton = floatingActionButton
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = UnifyDimens.Radius.Large,
                            topEnd = UnifyDimens.Radius.Large
                        )
                    )
                    .background(color = UnifyColors.White)
                    .padding(padding),
                content = content
            )
        }
    }
}