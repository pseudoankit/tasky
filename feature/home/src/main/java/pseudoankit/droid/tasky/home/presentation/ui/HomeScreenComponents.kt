package pseudoankit.droid.tasky.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.coreui.components.fab.UnifyFloatingButton
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.model.TaskyDate
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens
import pseudoankit.droid.coreui.util.extension.noRippleClickable

internal object HomeScreenComponents {

    @Composable
    internal fun TopBar(
        headerDate: String,
        onMonthSelected: () -> Unit
    ) {
        Row(
            modifier = Modifier.padding(UnifyDimens.ScreenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TopBarDateSection(headerDate, onMonthSelected)
        }
    }

    @Composable
    internal fun SelectedMonthDatePicker(
        listState: LazyListState,
        dateRange: ImmutableList<TaskyDate>,
        onDaySelected: (TaskyDate) -> Unit
    ) {
        LazyRow(modifier = Modifier.fillMaxWidth(), state = listState) {
            items(dateRange, key = { it.date.dayOfMonth }) { date ->
                SelectedMonthDatePickerItem(
                    date = date,
                    onClick = onDaySelected
                )
            }
        }
    }

    @Composable
    fun FloatingButton(
        onClick: () -> Unit,
        isSelected: Boolean
    ) {
        UnifyFloatingButton(
            iconConfig = UnifyIcon.Config(
                icon = if (isSelected) UnifyIcons.Cross else UnifyIcons.Add,
                size = UnifyDimens.Dp_36
            ),
            onClick = onClick
        )
    }

    @Composable
    private fun TopBarDateSection(
        headerDate: String,
        onMonthSelected: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(UnifyDimens.Radius.Small))
                .noRippleClickable(onClick = onMonthSelected)
                .padding(all = UnifyDimens.Dp_4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UnifyTextView(
                config = UnifyTextView.Config(
                    textType = UnifyTextType.BodyMedium,
                    text = headerDate,
                    color = UnifyColors.White
                )
            )
            UnifyIcon(
                config = UnifyIcon.Config(
                    icon = UnifyIcons.DropDown,
                    tint = UnifyColors.White
                )
            )
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