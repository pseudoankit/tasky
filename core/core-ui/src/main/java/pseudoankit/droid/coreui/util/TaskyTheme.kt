package pseudoankit.droid.coreui.util

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import org.koin.core.module.Module
import pseudoankit.droid.coreui.components.topbar.TaskyTopBar
import pseudoankit.droid.coreui.components.topbar.TaskyTopBarConfig

@Composable
fun TaskyDestinationSurface(
    topBarConfig: TaskyTopBarConfig,
    module: Module = org.koin.dsl.module { },
    content: @Composable ColumnScope.() -> Unit,
) {
    TaskyTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = TaskyColor.Black)
            ) {
                TaskyTopBar(config = topBarConfig)
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = TaskyDimens.Radius.Large,
                                topEnd = TaskyDimens.Radius.Large
                            )
                        ),
                    color = TaskyColor.White
                ) {
                    Column(modifier = Modifier.padding(TaskyDimens.ScreenPadding)) {
                        content()
                    }
                }
            }
        }
    }
}

private val DarkColorScheme = darkColorScheme(
    primary = TaskyColor.Purple80,
    secondary = TaskyColor.PurpleGrey80,
    tertiary = TaskyColor.Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = TaskyColor.Purple40,
    secondary = TaskyColor.PurpleGrey40,
    tertiary = TaskyColor.Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TaskyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}