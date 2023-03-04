package com.example.permission_manager

import android.os.Build
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.*
import pseudoankit.droid.unify.component.button.UnifyButton
import pseudoankit.droid.unify.component.button.UnifyButtonConfig

@OptIn(ExperimentalPermissionsApi::class)
val PermissionState.taskyStatus get() = when(this.status) {
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun DemoPermission() {
    val launcher = rememberPermissionState(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)

    when(launcher.taskyStatus) {
        TaskyPermissionStatus.Granted -> TODO()
        TaskyPermissionStatus.DeclinedOnce -> TODO()
        TaskyPermissionStatus.DeclinedPermanently -> TODO()
    }

    UnifyButton(UnifyButtonConfig(text = "Btn")) {
        launcher.launchPermissionRequest()
    }

}