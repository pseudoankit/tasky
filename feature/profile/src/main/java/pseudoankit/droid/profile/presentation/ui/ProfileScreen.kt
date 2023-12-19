package pseudoankit.droid.profile.presentation.ui

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import pseudoankit.droid.core.deeplink.TaskyDeeplink

@Destination(
    deepLinks = [
        DeepLink(uriPattern = TaskyDeeplink.profile)
    ]
)
@Composable
internal fun ProfileScreen() {

}