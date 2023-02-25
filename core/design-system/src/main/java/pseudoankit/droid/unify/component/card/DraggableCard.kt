package pseudoankit.droid.unify.component.card

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.utils.logs
import kotlin.math.roundToInt

// TODO right to left
object DraggableCard {
    private const val ANIMATION_DURATION = 500

    @Composable
    operator fun invoke(
        cardOffset: Float,
        revealThreshold: Float,
        content: @Composable () -> Unit
    ) {
        var isRevealed by remember { mutableStateOf(false) }
        val onExpand = remember { { isRevealed = true } }
        val onCollapse = remember { { isRevealed = false } }

        var offsetX by remember { mutableStateOf(0f) }
        val transition = GetTransition(isRevealed = isRevealed)
        val offsetTransition by GetOffsetTransition(transition, isRevealed, cardOffset, offsetX)
        val cardElevation by GetElevation(transition, isRevealed)

        UnifyCard(
            config = UnifyCard.Config(
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

    @Composable
    private fun GetElevation(
        transition: Transition<Boolean>,
        isRevealed: Boolean,
    ) = transition.animateDp(
        label = "cardElevation",
        transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
        targetValueByState = { if (isRevealed) 40.dp else 2.dp }
    )

    @Composable
    private fun GetOffsetTransition(
        transition: Transition<Boolean>,
        isRevealed: Boolean,
        cardOffset: Float,
        offsetX: Float
    ) = transition.animateFloat(
        label = "cardOffsetTransition",
        transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
        targetValueByState = { if (isRevealed) cardOffset - offsetX else -offsetX }
    )

    @Composable
    private fun GetTransition(isRevealed: Boolean): Transition<Boolean> {
        val transitionState = remember {
            MutableTransitionState(isRevealed).apply {
                targetState = !isRevealed
            }
        }
        return updateTransition(transitionState, "cardTransition")
    }

    @Composable
    private fun GetBackgroundColor(
        transition: Transition<Boolean>,
        isRevealed: Boolean,
        revealedBgColor: Color,
        collapsedBgColor: Color,
    ) = transition.animateColor(
        label = "cardBgColorTransition",
        transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
        targetValueByState = {
            if (isRevealed) revealedBgColor else collapsedBgColor
        }
    )
}