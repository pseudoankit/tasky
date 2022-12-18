package pseudoankit.droid.coreui.components.datepicker

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.date.DatePickerColors
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens
import java.time.LocalDate

/**
 * create date picker dialog
 * @param[datePickerState] pass the state of date picker, create state instance by [rememberUnifyDatePickerState]
 * @param[initialDate] date to be selected when picker is opened initially
 * @param[onDateSelected] callback when positive button is clicked
 */
@Composable
fun UnifyDatePicker(
    datePickerState: UnifyDatePickerState,
    initialDate: LocalDate = LocalDate.now(),
    onDateSelected: (LocalDate) -> Unit
) {
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
}

@Composable
private fun UnifyDatePickerImpl(
    datePickerState: MaterialDialogState,
    initialDate: LocalDate = LocalDate.now(),
    onDateSelected: (LocalDate) -> Unit,
    onCloseRequest: (MaterialDialogState) -> Unit
) {
    val onActionButtonClick = remember {
        {
            datePickerState.hide()
            onCloseRequest(datePickerState)
        }
    }
    val actionButtonTextStyle = remember {
        TextStyle.Default.copy(color = UnifyColors.Black)
    }

    MaterialDialog(
        dialogState = datePickerState,
        buttons = {
            positiveButton(
                "OK",
                onClick = onActionButtonClick,
                textStyle = actionButtonTextStyle
            )
            negativeButton(
                "Cancel",
                onClick = onActionButtonClick,
                textStyle = actionButtonTextStyle
            )
        },
        shape = RoundedCornerShape(UnifyDimens.Radius.Large),
        autoDismiss = true,
        onCloseRequest = onCloseRequest
    ) {
        datepicker(
            initialDate = initialDate,
            onDateChange = onDateSelected,
            colors = object : DatePickerColors {
                override val calendarHeaderTextColor: Color
                    get() = UnifyColors.White
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