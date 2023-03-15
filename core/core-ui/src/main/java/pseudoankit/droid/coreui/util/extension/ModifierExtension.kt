package pseudoankit.droid.coreui.util.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.placeWhileIgnoringHorizontalParentPadding(paddingToIgnore: Dp = 16.dp) = composed {
    layout { measurable, constraints ->
        val placeable = measurable.measure(
            constraints.copy(
                maxWidth = paddingToIgnore.roundToPx() + constraints.maxWidth + paddingToIgnore.roundToPx(), //add the end padding 16.dp
            )
        )
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}
