package pseudoankit.droid.unify.component.swipeablecard

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.component.card.UnifyCard
import pseudoankit.droid.unify.component.card.UnifyCardConfig
import pseudoankit.droid.unify.component.swipeablecard.SwipeableCardConfig.Direction
import kotlin.math.roundToInt

/**
 * config for [SwipeableCard]
 * @param direction specify the [Direction] of swipe in which user can move
 * @param maxOffsetToReveal maximum limit until which user can swipe the view and swiping further will have no effect
 * @param revealThreshold value till which if user drags, then view will be swiped to [maxOffsetToReveal],
 * eg: if [revealThreshold] is 20 then if user swipe value is >= 20 then it will automatically be swiped to [maxOffsetToReveal]
 * @param offsetValue initial offset value, value by which card will be swiped as per [direction] specified
 * @param elevationWhenRevealed elevation value when view is swiped
 */
data class SwipeableCardConfig(
    val direction: Direction,
    val maxOffsetToReveal: Float,
    val revealThreshold: Float,
    val offsetValue: Float = 0f,
    val elevationWhenRevealed: Dp = 8.dp,
) {

    /** direction of swipe movement */
    enum class Direction {
        /** Right to Left */
        RTL,

        /** Left to Right */
        LTR
    }
}


private const val MIN_OFFSET_TO_REVEAL: Float = 0f
private const val ANIMATION_DURATION = 500

/**
 * wrapper to create a swipeable view
 * @param config [SwipeableCardConfig] configurations of swipeable view
 * @param content actual content inside the view
 */
@Composable
fun SwipeableCard(
    config: SwipeableCardConfig,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = with(config) {
    var dragAmount by remember { mutableStateOf(0f) }
    var currentOffset by remember(offsetValue) { mutableStateOf(offsetValue) }
    val displayOffset by remember {
        derivedStateOf {
            when (direction) {
                Direction.RTL -> {
                    when {
                        currentOffset < MIN_OFFSET_TO_REVEAL -> -MIN_OFFSET_TO_REVEAL
                        currentOffset > maxOffsetToReveal -> -maxOffsetToReveal
                        else -> -currentOffset
                    }
                }
                Direction.LTR -> {
                    when {
                        currentOffset < MIN_OFFSET_TO_REVEAL -> MIN_OFFSET_TO_REVEAL
                        currentOffset > maxOffsetToReveal -> maxOffsetToReveal
                        else -> currentOffset
                    }
                }
            }
        }
    }

    UnifyCard(
        config = UnifyCardConfig(
            modifier = modifier
                .fillMaxWidth()
                .offset { IntOffset((displayOffset).roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            currentOffset = when (direction) {
                                Direction.RTL -> {
                                    if (-currentOffset < revealThreshold || dragAmount > 0) MIN_OFFSET_TO_REVEAL else -maxOffsetToReveal
                                }
                                Direction.LTR -> {
                                    if (currentOffset < revealThreshold || dragAmount < 0) MIN_OFFSET_TO_REVEAL else maxOffsetToReveal
                                }
                            }
                        }
                    ) { change, dragValue ->
                        dragAmount = dragValue
                        currentOffset += dragValue
                        if (change.positionChange() != Offset.Zero) change.consume()
                    }
                },
            elevation = animateDpAsState(
                targetValue = if (displayOffset != 0f) elevationWhenRevealed else 0.dp,
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            ).value,
        ),
        content = content
    )
}

private fun log(message: String) {
    println("SwipeableCardLogs : $message")
}
