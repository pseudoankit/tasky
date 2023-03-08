package pseudoankit.droid.splash.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import pseudoankit.droid.preferencesmanager.PreferenceRepository
import pseudoankit.droid.splash.navigator.SplashNavigator
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors

@Destination
@Composable
internal fun SplashScreen(
    splashNavigator: SplashNavigator
) {
    val preferenceRepository = get<PreferenceRepository>()
    val isLoggedIn by preferenceRepository.isLoggedIn().collectAsState(initial = false)

    LaunchedEffect(Unit) {
        delay(1000)
        splashNavigator.performNavigation(isUserLoggedIn = isLoggedIn)
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