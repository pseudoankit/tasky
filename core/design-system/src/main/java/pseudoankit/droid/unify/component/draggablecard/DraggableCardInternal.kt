package pseudoankit.droid.unify.component.draggablecard

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


// TODO right to left
internal object DraggableCardInternal {
     const val ANIMATION_DURATION = 500

    @Composable
     fun getElevation(
        transition: Transition<Boolean>,
        isRevealed: Boolean,
    ) = transition.animateDp(
        label = "cardElevation",
        transitionSpec = { tween(durationMillis = ANIMATION_DURATION) },
        targetValueByState = { if (isRevealed) 40.dp else 2.dp }
    )

    @Composable
     fun getOffsetTransition(
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
     fun getTransition(isRevealed: Boolean): Transition<Boolean> {
        val transitionState = remember {
            MutableTransitionState(isRevealed).apply {
                targetState = !isRevealed
            }
        }
        return updateTransition(transitionState, "cardTransition")
    }

    @Composable
     fun getBackgroundColor(
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