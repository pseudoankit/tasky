package pseudoankit.droid.unify.component.dialog.datepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import com.vanpra.composematerialdialogs.datetime.date.DatePickerColors
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.internal.rememberMutableState

internal object UnifyDatePickerToken {

    val colors = object : DatePickerColors {
        override val calendarHeaderTextColor: Color
            get() = UnifyColors.Black
        override val headerBackgroundColor: Color
            get() = UnifyColors.Black
        override val headerTextColor: Color
            get() = UnifyColors.White

        @Composable
        override fun dateBackgroundColor(active: Boolean): State<Color> {
            return rememberMutableState(
                value = if (active) UnifyColors.Black else UnifyColors.White,
                active,
            )
        }

        @Composable
        override fun dateTextColor(active: Boolean): State<Color> {
            return rememberMutableState(
                value = if (active) UnifyColors.White else UnifyColors.Black,
                active,
            )
        }
    }
}