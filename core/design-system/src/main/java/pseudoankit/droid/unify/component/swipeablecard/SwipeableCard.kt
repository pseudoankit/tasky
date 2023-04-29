package pseudoankit.droid.unify.component.swipeablecard

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.component.swipeablecard.SwipeableCardConfig.Direction
import com.pseudoankit.swipeable_card.SwipeableCard as LibSwipeableCard
import com.pseudoankit.swipeable_card.SwipeableCardConfig as LibSwipeableCardConfig

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
    LibSwipeableCard(
        config = LibSwipeableCardConfig(
            direction = direction.rdsValue,
            maxOffsetToReveal = maxOffsetToReveal,
            revealThreshold = revealThreshold,
            offsetValue = offsetValue,
            elevationWhenRevealed = elevationWhenRevealed
        ),
        modifier = modifier.padding(1.dp),
        color = Color.Transparent,
        content = content
    )
}

private val Direction.rdsValue
    get() = when (this) {
        Direction.RTL -> com.pseudoankit.swipeable_card.SwipeableCardConfig.Direction.RTL
        Direction.LTR -> com.pseudoankit.swipeable_card.SwipeableCardConfig.Direction.LTR
    }
