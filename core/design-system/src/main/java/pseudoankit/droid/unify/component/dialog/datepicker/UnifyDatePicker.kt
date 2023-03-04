package pseudoankit.droid.unify.component.dialog.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import pseudoankit.droid.unify.component.dialog.UnifyDialog
import pseudoankit.droid.unify.component.dialog.UnifyDialogState
import pseudoankit.droid.unify.component.dialog.rememberUnifyDialogState
import java.time.LocalDate

/**
 * create date picker dialog
 * @param[initialDate] date to be selected when picker is opened initially
 */
@Immutable
data class UnifyDatePickerConfig(
    val initialDate: LocalDate = LocalDate.now()
)

/**
 * create date picker dialog
 * @param[datePickerState] pass the state of date picker, create state instance by [rememberUnifyDialogState()]
 * @param[onDateChanged] callback when positive button is clicked
 * @param config configs for date picker
 */
@Composable
fun UnifyDatePicker(
    config: UnifyDatePickerConfig,
    datePickerState: UnifyDialogState,
    onDateChanged: (LocalDate) -> Unit,
) = with(config) {
    UnifyDialog(state = datePickerState) {
        datepicker(
            initialDate = initialDate,
            onDateChange = onDateChanged,
            colors = UnifyDatePickerToken.colors
        )
    }
}
