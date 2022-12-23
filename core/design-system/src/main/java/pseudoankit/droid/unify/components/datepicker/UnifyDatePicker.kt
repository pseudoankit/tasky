package pseudoankit.droid.unify.components.datepicker

import androidx.compose.runtime.Composable
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

/**
 * create date picker dialog
 * @param[datePickerState] pass the state of date picker, create state instance by [rememberUnifyDatePickerState]
 * @param[initialDate] date to be selected when picker is opened initially
 * @param[onDateSelected] callback when positive button is clicked
 */
object UnifyDatePicker {
    @Composable
    operator fun invoke(
        initialDate: LocalDate = LocalDate.now(),
        onDateSelected: (LocalDate) -> Unit
    ): UnifyDatePickerState {
        val datePickerState = rememberUnifyDatePickerState()

        val materialPickerState = rememberMaterialDialogState()
        when (datePickerState.showing) {
            true -> materialPickerState.show()
            false -> materialPickerState.hide()
        }

        UnifyDatePickerInternal(
            datePickerState = materialPickerState,
            initialDate = initialDate,
            onDateSelected = onDateSelected,
            onCloseRequest = {
                datePickerState.hide()
            }
        )

        return datePickerState
    }
}