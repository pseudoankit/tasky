package pseudoankit.droid.unify.components.datetimepicker.datepicker

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
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens
import java.time.LocalDate

internal object UnifyDatePickerImpl {
    @Composable
    operator fun invoke(
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