package pseudoankit.droid.unify.components.card

import androidx.compose.animation.core.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

private const val ANIMATION_DURATION = 500
const val MIN_DRAG_AMOUNT = 6
private const val CARD_OFFSET = 50f

@Composable
fun DraggableCard(
    content: @Composable () -> Unit
) {
    var isRevealed by remember { mutableStateOf(false) }
    val onExpand = remember { { isRevealed = true } }
    val onCollapse = remember { { isRevealed = false } }

    val offsetX = remember { mutableStateOf(0f) }
    val transitionState = remember {
        MutableTransitionState(isRevealed).apply {
            targetState = !isRevealed
        }
    }
    val transition = updateTransition(transitionState, "cardTransition")
//        val backgroundColor by transition.animateColor(
//            label = "cardBgColorTransition",
//            transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
//            targetValueByState = {
//                bgColor
//            }
//        )
    val offsetTransition by transition.animateFloat(
        label = "cardOffsetTransition",
        transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
        targetValueByState = { if (isRevealed) CARD_OFFSET - offsetX.value else -offsetX.value }

    )
    val cardElevation by transition.animateDp(
        label = "cardElevation",
        transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
        targetValueByState = { if (isRevealed) 40.dp else 2.dp }
    )

    UnifyCard(
        config = UnifyCard.Config(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset((offsetX.value + offsetTransition).roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { change, dragAmount ->
                        val original = Offset(offsetX.value, 0f)
                        val summed = original + Offset(x = dragAmount, y = 0f)
                        val newValue = Offset(x = summed.x.coerceIn(0f, CARD_OFFSET), y = 0f)
                        if (newValue.x >= 10) {
                            onExpand()
                            return@detectHorizontalDragGestures
                        } else if (newValue.x <= 0) {
                            onCollapse()
                            return@detectHorizontalDragGestures
                        }
                        if (change.positionChange() != Offset.Zero) change.consume()
                        offsetX.value = newValue.x
                    }
                },
            elevation = cardElevation,
        ),
        content = content
    )
}