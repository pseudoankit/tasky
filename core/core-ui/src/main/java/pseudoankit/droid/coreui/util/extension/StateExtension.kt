package pseudoankit.droid.coreui.util.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun <T> rememberMutableStateOf(value: T, vararg keys: Any): MutableState<T> = remember(*keys) {
    mutableStateOf(value)
}
