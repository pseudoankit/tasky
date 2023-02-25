package pseudoankit.droid.unify.component.dialog.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.vanpra.composematerialdialogs.datetime.date.DatePickerColors
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import pseudoankit.droid.unify.component.dialog.UnifyDialog
import pseudoankit.droid.unify.component.dialog.UnifyDialogState
import pseudoankit.droid.unify.token.UnifyColors
import java.time.LocalDate

internal object UnifyDatePickerImpl {

    @Composable
    operator fun invoke(
        datePickerState: UnifyDialogState,
        initialDate: LocalDate,
        onDateSelected: (LocalDate) -> Unit
    ) {
        UnifyDialog(state = datePickerState) {
            datepicker(
                initialDate = initialDate,
                onDateChange = onDateSelected,
                colors = colors
            )
        }
    }

    private val colors = object : DatePickerColors {
        override val calendarHeaderTextColor: Color
            get() = UnifyColors.Black
        override val headerBackgroundColor: Color
            get() = UnifyColors.Black
        override val headerTextColor: Color
            get() = UnifyColors.White

        @Composable
        override fun dateBackgroundColor(active: Boolean): State<Color> {
            return mutableStateOf(if (active) UnifyColors.Black else UnifyColors.White)
        }

        @Composable
        override fun dateTextColor(active: Boolean): State<Color> {
            return mutableStateOf(if (active) UnifyColors.White else UnifyColors.Black)
        }
    }
}