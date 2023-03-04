package pseudoankit.droid.unify.draggablecard

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.IntOffset
import pseudoankit.droid.unify.component.card.UnifyCard
import pseudoankit.droid.unify.component.card.UnifyCardConfig
import pseudoankit.droid.unify.draggablecard.DraggableCardInternal.getOffsetTransition
import pseudoankit.droid.unify.utils.logs
import kotlin.math.roundToInt

@Composable
fun DraggableCard(
    cardOffset: Float,
    revealThreshold: Float,
    content: @Composable () -> Unit
) {
    var isRevealed by remember { mutableStateOf(false) }
    val onExpand = remember { { isRevealed = true } }
    val onCollapse = remember { { isRevealed = false } }

    var offsetX by remember { mutableStateOf(0f) }
    val transition = DraggableCardInternal.getTransition(isRevealed = isRevealed)
    val offsetTransition by getOffsetTransition(transition, isRevealed, cardOffset, offsetX)
    val cardElevation by DraggableCardInternal.getElevation(transition, isRevealed)

    UnifyCard(
        config = UnifyCardConfig(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset((offsetX + offsetTransition).roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { change, dragAmount ->
                        val original = Offset(offsetX, 0f)
                        val summed = original + Offset(x = dragAmount, y = 0f)
                        val newValue = Offset(x = summed.x.coerceIn(0f, cardOffset), y = 0f)
                        if (newValue.x >= revealThreshold) {
                            logs("new value $newValue")
                            onExpand()
                            return@detectHorizontalDragGestures
                        } else if (newValue.x <= 0) {
                            onCollapse()
                            return@detectHorizontalDragGestures
                        }
                        if (change.positionChange() != Offset.Zero) change.consume()
                        offsetX = newValue.x
                    }
                },
            elevation = cardElevation,
        ),
        content = content
    )
}
