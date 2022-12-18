package pseudoankit.droid.tasky.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.model.TaskyDate
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens

object HomeScreenComponents {

    @Composable
    internal fun SelectedMonthDatePicker(
        dayRange: ImmutableList<TaskyDate>,
        onDaySelected: (TaskyDate) -> Unit,
        selectedDay: TaskyDate
    ) {
        val listState = rememberLazyListState()

        LazyRow(modifier = Modifier.fillMaxWidth(), state = listState) {
            items(dayRange, key = { it.date.dayOfMonth }) { day ->
                SelectedMonthDatePickerItem(
                    date = day,
                    onClick = onDaySelected
                )
            }
        }

        LaunchedEffect(Unit) {
            listState.scrollToItem(selectedDay.date.dayOfMonth - 1)
        }
    }

    @Composable
    private fun SelectedMonthDatePickerItem(
        date: TaskyDate, onClick: (TaskyDate) -> Unit
    ) = date.date.run {
        Column(
            modifier = Modifier
                .width(UnifyDimens.Dp_36)
                .height(UnifyDimens.Dp_50)
                .clip(RoundedCornerShape(UnifyDimens.Radius.Medium))
                .clickable { onClick(date) }
                .background(color = if (date.isSelected) UnifyColors.Orange else UnifyColors.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            UnifyTextView(
                config = UnifyTextView.Config(
                    text = "${dayOfWeek.name[0]}",
                    textType = UnifyTextType.LabelMedium
                )
            )
            UnifyTextView(
                config = UnifyTextView.Config(
                    text = "$dayOfMonth",
                    textType = UnifyTextType.TitleMedium
                )
            )
        }
    }
}