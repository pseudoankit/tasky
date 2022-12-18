package pseudoankit.droid.coreui.components.fab

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens

@Composable
fun UnifyFloatingButton(
    modifier: Modifier = Modifier,
    iconConfig: UnifyIcon.Config,
    onClick: () -> Unit,
) {
    val updatedIconConfig = remember(iconConfig) {
        iconConfig.copy(tint = UnifyColors.White)
    }

    FloatingActionButton(
        onClick = onClick,
        shape = RoundedCornerShape(UnifyDimens.Radius.Small),
        containerColor = UnifyColors.Black,
        modifier = modifier
    ) {
        UnifyIcon(config = updatedIconConfig)
    }
}