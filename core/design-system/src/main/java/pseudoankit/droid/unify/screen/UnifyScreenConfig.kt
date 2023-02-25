package pseudoankit.droid.unify.screen

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import pseudoankit.droid.unify.component.topbar.UnifyTopBar

/**
 * @param[topBar] for custom topBars
 */
data class UnifyScreenConfig(
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