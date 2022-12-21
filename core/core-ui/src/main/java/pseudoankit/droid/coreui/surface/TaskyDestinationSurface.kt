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
 * Helper method to configure repeating logic for any destination
 * @param[topBarConfig] topBar or actionBar configs
 * @param[singleEvents] add any code that needs to just run once
 * @param[content] actual composable content of screen
 */
@Composable
fun TaskyDestinationSurface(
    topBarConfig: UnifyTopBar.Config? = null,
    singleEvents: suspend CoroutineScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    TaskyDestinationSurface(
        topBar = {
            UnifyTopBar(topBarConfig)
        },
        singleEvents = singleEvents,
        content = content
    )
}

/**
 * Helper method to configure repeating logic for any destination
 * @param[topBar] for custom topBars
 * @param[singleEvents] add any code that needs to just run once
 * @param[content] actual composable content of screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskyDestinationSurface(
    topBar: @Composable BoxScope.() -> Unit,
    floatingActionButton: @Composable () -> Unit = {},
    singleEvents: suspend CoroutineScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    LaunchedEffect(key1 = Unit, block = singleEvents)
    UnifyTheme {
        Scaffold(
            topBar = {
                Box(modifier = Modifier.height(UnifyDimens.Dp_64), content = topBar)
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
                    .padding(UnifyDimens.ScreenPadding),
                content = content
            )
        }
    }
}