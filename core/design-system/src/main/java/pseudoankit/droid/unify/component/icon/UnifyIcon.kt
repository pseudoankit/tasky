package pseudoankit.droid.unify.component.icon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.unify.token.UnifyDimens

/**
 * Icon composable to display icon
 * @param config configurations for icon
 */
@Composable
fun UnifyIcon(config: UnifyIconConfig?) {
    when {
        config == null -> return
        config.onClick != null -> CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides config.provideTouchTargetSpacing) {
            IconButton(onClick = config.onClick, modifier = config.modifier) {
                UnifyIconInternal(config = config)
            }
        }
        else -> Box(modifier = config.modifier, contentAlignment = Alignment.Center) {
            UnifyIconInternal(config = config)
        }
    }
}

/**
 * @param[icon] icon to show
 * @param[size] size of icon
 * @param[onClick] consuming onClick will use icon button to provide ripple effect
 * @param[provideTouchTargetSpacing] boolean to change extra padding when using icon button
 * @param modifier modifier of outer box in which icon is wrapped
 */
data class UnifyIconConfig(
    val icon: UnifyIcons,
    val modifier: Modifier = Modifier,
    val contentDescription: String = "",
    val tint: Color = Color.Black,
    val size: Dp = UnifyDimens.Dp_24,
    val onClick: (() -> Unit)? = null,
    val provideTouchTargetSpacing: Boolean = false
)

