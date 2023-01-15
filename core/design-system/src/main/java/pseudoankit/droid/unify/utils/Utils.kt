package pseudoankit.droid.unify.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import pseudoankit.droid.unify.R

typealias UnifyDrawable = R.drawable

@Composable
fun rememberFocusRequester() = remember {
    FocusRequester()
}

