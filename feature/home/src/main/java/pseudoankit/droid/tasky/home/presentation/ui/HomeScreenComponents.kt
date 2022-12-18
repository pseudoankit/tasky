package pseudoankit.droid.tasky.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import pseudoankit.droid.core.util.datetime.DateUtils
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens
import java.time.LocalDate

object HomeScreenComponents {

    @Composable
    internal fun SelectedMonthDatePicker(selectedDate: LocalDate) {
        val dayRange = remember(selectedDate) {
            DateUtils.getDayRangeForDate(selectedDate)
        }

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(dayRange) {
                SelectedMonthDatePickerItem(date = it)
            }
        }
    }

    @Composable
    private fun SelectedMonthDatePickerItem(date: LocalDate) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(UnifyDimens.Radius.XSmall))
                .background(color = UnifyColors.LightBlue)
        ) {
            UnifyTextView(
                config = UnifyTextView.Config(
                    text = "${date.dayOfMonth}",
                    textType = UnifyTextType.LabelSmall
                )
            )
            UnifyTextView(
                config = UnifyTextView.Config(
                    text = "${date.dayOfWeek.name[0]}",
                    textType = UnifyTextType.LabelSmall
                )
            )
        }
    }
}