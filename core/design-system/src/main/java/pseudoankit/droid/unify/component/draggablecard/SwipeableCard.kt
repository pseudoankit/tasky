package pseudoankit.droid.unify.component.draggablecard

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
import pseudoankit.droid.unify.component.card.UnifyCard
import pseudoankit.droid.unify.component.card.UnifyCardConfig
import kotlin.math.roundToInt

data class SwipeableCardConfig(
    val direction: Direction,
    val revealThreshold: Float,
    val maxOffsetToReveal: Float
) {
    enum class Direction {
        RTL, LTR
    }
}

@Composable
fun SwipeableCard(
    config: SwipeableCardConfig,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = with(config) {
    var _offset by remember { mutableStateOf(0f) }
    val offset by remember {
        derivedStateOf {
            when {
                _offset < 0f -> 0f
                _offset > maxOffsetToReveal -> maxOffsetToReveal
                else -> _offset
            }
        }
    }

    var elevation by remember { mutableStateOf(0.dp) }

    UnifyCard(
        config = UnifyCardConfig(
            modifier = modifier
                .fillMaxWidth()
                .offset { IntOffset((offset).roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            when (direction) {
                                SwipeableCardConfig.Direction.RTL -> {
                                    _offset =
                                        if (-_offset < revealThreshold) 0f else -maxOffsetToReveal
                                }
                                SwipeableCardConfig.Direction.LTR -> {
                                    _offset =
                                        if (_offset < revealThreshold) 0f else maxOffsetToReveal
                                }
                            }
                        }
                    ) { change, dragAmount ->
                        when (direction) {
                            SwipeableCardConfig.Direction.RTL -> {
                                val newOffset = -(_offset + dragAmount)
                                _offset = when {
                                    newOffset < 0f -> 0f
                                    newOffset > maxOffsetToReveal -> -maxOffsetToReveal
                                    else -> -newOffset
                                }
                            }
                            SwipeableCardConfig.Direction.LTR -> {
                                _offset += dragAmount
                            }
                        }
                        if (change.positionChange() != Offset.Zero) change.consume()
                    }
                },
            elevation = elevation,
        ),
        content = content
    )
}

private fun SwipeableCardConfig.shouldConsumeDragAmount(dragAmount: Float) = when (direction) {
    SwipeableCardConfig.Direction.RTL -> dragAmount < 0
    SwipeableCardConfig.Direction.LTR -> dragAmount > 0
}
