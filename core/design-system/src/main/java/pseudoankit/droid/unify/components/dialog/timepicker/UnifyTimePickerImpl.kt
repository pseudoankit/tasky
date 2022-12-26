package pseudoankit.droid.unify.components.dialog.timepicker

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.time.TimePickerColors
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import pseudoankit.droid.unify.components.dialog.core.UnifyMaterialDialog
import pseudoankit.droid.unify.token.UnifyColors
import java.time.LocalTime

internal object UnifyTimePickerImpl {
    @Composable
    operator fun invoke(
        timePickerState: MaterialDialogState,
        initialTime: LocalTime,
        onTimeChanged: (LocalTime) -> Unit,
        onCloseRequest: (MaterialDialogState) -> Unit
    ) {
        val def = TimePickerDefaults.colors()
        UnifyMaterialDialog(
            state = timePickerState,
            onCloseRequest = onCloseRequest
        ) {
            timepicker(
                initialTime = initialTime,
                onTimeChange = onTimeChanged,
                colors = object : TimePickerColors {
                    override val border: BorderStroke
                        get() = BorderStroke(1.dp, UnifyColors.Black)

                    @Composable
                    override fun backgroundColor(active: Boolean): State<Color> {
                        return mutableStateOf(if (active) UnifyColors.LightBlue else UnifyColors.Black)
                    }

                    override fun headerTextColor(): Color {
                        return def.headerTextColor()
                    }

                    @Composable
                    override fun periodBackgroundColor(active: Boolean): State<Color> {
                        return mutableStateOf(if (active) UnifyColors.LightBlue else UnifyColors.Black)
                    }

                    override fun selectorColor(): Color {
                        return UnifyColors.LightBlue
                    }

                    override fun selectorTextColor(): Color {
                        return UnifyColors.LightBlue
                    }

                    @Composable
                    override fun textColor(active: Boolean): State<Color> {
                        return mutableStateOf(UnifyColors.White)
                    }
                }
            )
        }
    }
}