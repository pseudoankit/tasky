package pseudoankit.droid.tasky.home.presentation.home.ui

import android.os.Build
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.permission_manager.isGranted
import com.example.permission_manager.requestPermission
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.delay
import pseudoankit.droid.coreui.util.extension.rememberMutableStateOf
import pseudoankit.droid.unify.component.pill.UnifyPill
import pseudoankit.droid.unify.component.pill.UnifyPillConfig
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors

private const val NOTIFICATION_BANNER_TIME_LIMIT = 10000L

@Composable
fun ShowBannerAndRequestIfNotificationPermissionDenied() {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return

    val context = LocalContext.current
    val permissionStatus =
        rememberPermissionState(permission = android.Manifest.permission.POST_NOTIFICATIONS)

    var timerLimitReached by rememberMutableStateOf(value = false)
    val shouldShowBanner = permissionStatus.isGranted.not() && timerLimitReached.not()

    LaunchedEffect(Unit) {
        delay(NOTIFICATION_BANNER_TIME_LIMIT)
        timerLimitReached = true
    }

    AnimatedVisibility(
        visible = shouldShowBanner
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(UnifyColors.Gray700)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UnifyTextView(
                config = UnifyTextViewConfig(
                    text = "We will not be able to remind you about your upcoming events, Please grant notification permission !",
                    color = UnifyColors.White,
                    modifier = Modifier.weight(1f)
                )
            )
            UnifyPill(
                config = UnifyPillConfig(
                    label = "Grant"
                ),
                onClick = {
                    permissionStatus.requestPermission(context = context)
                }
            )
        }
    }
}
