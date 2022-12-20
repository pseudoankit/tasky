package pseudoankit.droid.coreui.components.fab

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.token.UnifyColors

object UnifyFloatingButton {

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        iconConfig: UnifyIcon.Config,
        onClick: () -> Unit,
    ) {
        val updatedIconConfig = remember(iconConfig) {
            iconConfig.copy(tint = UnifyColors.White)
        }

        FloatingActionButton(
            onClick = onClick,
            shape = CircleShape,
            containerColor = UnifyColors.Black,
            modifier = modifier
        ) {
            UnifyIcon(config = updatedIconConfig)
        }
    }
}