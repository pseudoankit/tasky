package pseudoankit.droid.unify.components.datetimepicker.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.date.DatePickerColors
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import pseudoankit.droid.unify.components.dialog.UnifyMaterialDialog
import pseudoankit.droid.unify.token.UnifyColors
import java.time.LocalDate

internal object UnifyDatePickerImpl {
    @Composable
    operator fun invoke(
        datePickerState: MaterialDialogState,
        initialDate: LocalDate = LocalDate.now(),
        onDateSelected: (LocalDate) -> Unit,
        onCloseRequest: (MaterialDialogState) -> Unit
    ) {
        UnifyMaterialDialog(
            state = datePickerState,
            onCloseRequest = onCloseRequest
        ) {
            datepicker(
                initialDate = initialDate,
                onDateChange = onDateSelected,
                colors = object : DatePickerColors {
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
            )
        }
    }
}