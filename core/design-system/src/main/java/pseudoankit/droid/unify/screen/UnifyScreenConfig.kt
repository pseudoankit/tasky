package pseudoankit.droid.unify.screen

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import pseudoankit.droid.unify.component.topbar.UnifyTopBar
import pseudoankit.droid.unify.component.topbar.UnifyTopBarConfig

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
        topBar: UnifyTopBarConfig? = null,
        floatingActionButton: @Composable () -> Unit = {},
    ) : this(
        topBar = {
            UnifyTopBar(topBar)
        },
        floatingActionButton = floatingActionButton,
    )
}