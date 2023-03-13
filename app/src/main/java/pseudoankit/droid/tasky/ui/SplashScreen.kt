package pseudoankit.droid.tasky.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import kotlinx.coroutines.delay
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors

internal const val SPLASH_SCREEN_TIME_OUT = 1000L

@Composable
internal fun SplashScreen(
    onSplashScreenDisplayFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(SPLASH_SCREEN_TIME_OUT)
        onSplashScreenDisplayFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(UnifyColors.Blue700),
        contentAlignment = Alignment.Center
    ) {
        UnifyTextView(
            config = UnifyTextViewConfig(
                text = "Tasky",
                textType = UnifyTextType.HeadlineLarge,
                color = UnifyColors.White,
                fontStyle = FontStyle.Italic
            )
        )
    }
}