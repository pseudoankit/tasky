package pseudoankit.droid.unify.components.dialog.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import pseudoankit.droid.unify.components.dialog.UnifyDialogState
import pseudoankit.droid.unify.components.dialog.rememberUnifyDialogState
import java.time.LocalDate

/**
 * create date picker dialog
 * @param[datePickerState] pass the state of date picker, create state instance by [rememberUnifyDialogState()]
 * @param[initialDate] date to be selected when picker is opened initially
 * @param[onDateSelected] callback when positive button is clicked
 */
object UnifyDatePicker {

    @Composable
    operator fun invoke(config: Config): UnifyDialogState = with(config) {
        val datePickerState = rememberUnifyDialogState()

        UnifyDatePickerImpl(
            datePickerState = datePickerState,
            initialDate = initialDate,
            onDateSelected = onDateChanged
        )

        return datePickerState
    }

    @Stable
    data class Config(
        val initialDate: LocalDate = LocalDate.now(),
        val onDateChanged: (LocalDate) -> Unit
    )
}