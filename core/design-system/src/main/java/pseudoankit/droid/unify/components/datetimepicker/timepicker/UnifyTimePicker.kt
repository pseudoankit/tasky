package pseudoankit.droid.unify.components.datetimepicker.timepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import pseudoankit.droid.unify.components.dialog.UnifyDialogState
import pseudoankit.droid.unify.components.dialog.rememberUnifyDialogState
import java.time.LocalTime

/**
 * create date picker dialog
 * @param[timePickerState] pass the state of date picker, create state instance by [rememberUnifyDialogState()]
 * @param[initialTime] date to be selected when picker is opened initially
 * @param[onTimeSelected] callback when positive button is clicked
 */
object UnifyTimePicker {

    @Composable
    operator fun invoke(config: Config): UnifyDialogState = with(config) {
        val timePickerState = rememberUnifyDialogState()

        val materialPickerState = rememberMaterialDialogState()
        when (timePickerState.showing) {
            true -> materialPickerState.show()
            false -> materialPickerState.hide()
        }

        UnifyTimePickerImpl(
            initialTime = initialTime,
            timePickerState = materialPickerState,
            onTimeChanged = onTimeChanged,
            onCloseRequest = {
                timePickerState.hide()
            }
        )

        return timePickerState
    }

    /**
     * @param[initialTime] date to be selected when picker is opened initially
     * @param[onTimeChanged] callback when positive button is clicked
     */
    @Stable
    data class Config(
        val initialTime: LocalTime = LocalTime.now(),
        val onTimeChanged: (LocalTime) -> Unit
    )
}