package pseudoankit.droid.unify.component.dialog.timepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import pseudoankit.droid.unify.component.dialog.UnifyDialog
import pseudoankit.droid.unify.component.dialog.UnifyDialogState
import java.time.LocalTime

/**
 * create date picker dialog
 * @param[timePickerState] pass the state of date picker, create state instance by [rememberUnifyDialogState()]
 * @param[config] config param for time picker
 * @param[onTimeChanged] callback when positive button is clicked
 */

@Composable
fun UnifyTimePicker(
    config: UnifyTimePickerConfig,
    timePickerState: UnifyDialogState,
    onTimeChanged: (LocalTime) -> Unit
) = with(config) {
    UnifyDialog(
        state = timePickerState
    ) {
        timepicker(
            initialTime = initialTime,
            onTimeChange = onTimeChanged,
            colors = UnifyTimePickerToken.colors
        )
    }
}

/**
 * @param[initialTime] date to be selected when picker is opened initially
 */
@Stable
data class UnifyTimePickerConfig(
    val initialTime: LocalTime = LocalTime.now()
)
