package pseudoankit.droid.tasky.util

import androidx.core.splashscreen.SplashScreen

fun SplashScreen.show() {
    setKeepOnScreenCondition { true }
}

fun SplashScreen.hide() {
    setKeepOnScreenCondition { false }
}