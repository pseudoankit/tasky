package pseudoankit.droid.unify.components.datetimepicker.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
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
    operator fun invoke(config: Config): UnifyDatePickerState = with(config) {
        val datePickerState = rememberUnifyDatePickerState()

        val materialPickerState = rememberMaterialDialogState()
        when (datePickerState.showing) {
            true -> materialPickerState.show()
            false -> materialPickerState.hide()
        }

        UnifyDatePickerImpl(
            datePickerState = materialPickerState,
            initialDate = initialDate,
            onDateSelected = onDateSelected,
            onCloseRequest = {
                datePickerState.hide()
            }
        )

        return datePickerState
    }

    @Stable
    data class Config(
        val initialDate: LocalDate = LocalDate.now(),
        val onDateSelected: (LocalDate) -> Unit
    )
}