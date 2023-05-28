package com.example.permission_manager

import android.content.Context
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import pseudoankit.droid.coreui.util.extension.navigateToSettings
import pseudoankit.droid.unify.component.button.UnifyButton
import pseudoankit.droid.unify.component.button.UnifyButtonConfig

fun PermissionState.requestPermission(context: Context) = when (taskyStatus) {
    TaskyPermissionStatus.Granted -> { /* no-op */
    }
    TaskyPermissionStatus.DeclinedOnce -> launchPermissionRequest()
    TaskyPermissionStatus.DeclinedPermanently -> context.navigateToSettings()
}

val PermissionState.isGranted get() = this.status == PermissionStatus.Granted

val PermissionState.taskyStatus
    get() = when (this.status) {
        is PermissionStatus.Denied -> {
            if (this.status.shouldShowRationale) {
                TaskyPermissionStatus.DeclinedOnce
            } else {
                TaskyPermissionStatus.DeclinedPermanently
            }
        }
        PermissionStatus.Granted -> {
            TaskyPermissionStatus.Granted
        }
    }

@Composable
internal fun DemoPermission() {
    val launcher =
        rememberPermissionState(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)

    when (launcher.taskyStatus) {
        TaskyPermissionStatus.Granted -> {}
        TaskyPermissionStatus.DeclinedOnce -> {}
        TaskyPermissionStatus.DeclinedPermanently -> {}
    }

    UnifyButton(UnifyButtonConfig(text = "Btn")) {
        launcher.launchPermissionRequest()
    }

}