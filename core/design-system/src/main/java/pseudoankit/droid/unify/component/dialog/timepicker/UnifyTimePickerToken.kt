package pseudoankit.droid.unify.component.dialog.timepicker

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.datetime.time.TimePickerColors
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyTokens
import pseudoankit.droid.unify.utils.internal.rememberMutableState

internal object UnifyTimePickerToken {

    val colors: TimePickerColors
        @Composable get() {
            val def = TimePickerDefaults.colors()

            return object : TimePickerColors {
                override val border: BorderStroke
                    get() = BorderStroke(1.dp, UnifyColors.Black)

                @Composable
                override fun backgroundColor(active: Boolean): State<Color> {
                    return rememberMutableState(
                        value = if (active) UnifyTokens.TimePicker.SelectedColor else UnifyColors.Black,
                        active,
                    )
                }

                override fun headerTextColor(): Color {
                    return def.headerTextColor()
                }

                @Composable
                override fun periodBackgroundColor(active: Boolean): State<Color> {
                    return rememberMutableState(
                        value = if (active) UnifyTokens.TimePicker.SelectedColor else UnifyColors.Black,
                        active,
                    )
                }

                override fun selectorColor(): Color {
                    return UnifyTokens.TimePicker.SelectedColor
                }

                override fun selectorTextColor(): Color {
                    return UnifyTokens.TimePicker.SelectedColor
                }

                @Composable
                override fun textColor(active: Boolean): State<Color> {
                    return rememberMutableState(value = UnifyColors.White)
                }
            }
        }
}