package pseudoankit.droid.unify.utils.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
internal fun <T> rememberMutableState(value: T, vararg keys: Any?) = remember(*keys) {
    mutableStateOf(value)
}