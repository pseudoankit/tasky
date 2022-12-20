package pseudoankit.droid.unify.components.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import pseudoankit.droid.unify.token.UnifyDimens

/**
 * Icon composable to display icon
 * @param[icon] icon to show
 * @param[size] size of icon **size passed via modifier will override by this size**
 * @param[onClick] **consuming onClick will use icon button to provide ripple effect**
 */
object UnifyIcon {

    @Composable
    operator fun invoke(config: Config?) {
        when {
            config == null -> return
            config.onClick != null -> IconButton(onClick = config.onClick) {
                UnifyIconInternalIcon(config = config)
            }
            else -> UnifyIconInternalIcon(config = config)
        }
    }

    /**
     * @param[icon] icon to show
     * @param[size] size of icon **size passed via modifier will override by this size**
     * @param[onClick] consuming onClick will use icon button to provide ripple effect
     */
    data class Config(
        val icon: UnifyIcons,
        val modifier: Modifier = Modifier,
        val contentDescription: String = "",
        val tint: Color = Color.Black,
        val size: Dp = UnifyDimens.Dp_24,
        val onClick: (() -> Unit)? = null
    )
}
