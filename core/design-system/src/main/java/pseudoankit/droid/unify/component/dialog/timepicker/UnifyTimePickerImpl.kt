package pseudoankit.droid.unify.component.dialog.timepicker

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.datetime.time.TimePickerColors
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import pseudoankit.droid.unify.component.dialog.UnifyDialog
import pseudoankit.droid.unify.component.dialog.UnifyDialogState
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTokens
import java.time.LocalTime

internal object UnifyTimePickerImpl {
    @Composable
    operator fun invoke(
        timePickerState: UnifyDialogState,
        initialTime: LocalTime,
        onTimeChanged: (LocalTime) -> Unit
    ) {
        UnifyDialog(
            state = timePickerState
        ) {
            timepicker(
                initialTime = initialTime,
                onTimeChange = onTimeChanged,
                colors = colors
            )
        }
    }

    private val colors: TimePickerColors
        @Composable get() {
            val def = TimePickerDefaults.colors()

            return object : TimePickerColors {
                override val border: BorderStroke
                    get() = BorderStroke(1.dp, UnifyColors.Black)

                @Composable
                override fun backgroundColor(active: Boolean): State<Color> {
                    return mutableStateOf(if (active) UnifyTokens.TimePicker.SelectedColor else UnifyColors.Black)
                }

                override fun headerTextColor(): Color {
                    return def.headerTextColor()
                }

                @Composable
                override fun periodBackgroundColor(active: Boolean): State<Color> {
                    return mutableStateOf(if (active) UnifyTokens.TimePicker.SelectedColor else UnifyColors.Black)
                }

                override fun selectorColor(): Color {
                    return UnifyTokens.TimePicker.SelectedColor
                }

                override fun selectorTextColor(): Color {
                    return UnifyTokens.TimePicker.SelectedColor
                }

                @Composable
                override fun textColor(active: Boolean): State<Color> {
                    return mutableStateOf(UnifyColors.White)
                }
            }
        }
}