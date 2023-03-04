package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.coreui.util.extension.noRippleClickable
import pseudoankit.droid.unify.component.fab.UnifyFloatingButton
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object HomeScreenComponents {

    @Composable
    fun SavedAgendaItems(
        items: ImmutableList<AgendaItem>,
        onItemCompletionToggled: (AgendaItem) -> Unit,
        onEdit: (AgendaItem) -> Unit,
        onDelete: (AgendaItem) -> Unit,
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(UnifyDimens.Dp_12)) {
            items(items) {
                SavedAgendaItem(
                    agendaItem = it,
                    onCompletionToggled = {
                        onItemCompletionToggled(it)
                    },
                    onEdit = {
                        onEdit(it)
                    },
                    onDelete = {
                        onDelete(it)
                    }
                )
            }
        }
    }

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
        onDaySelected: (TaskyDate) -> Unit,
        selectedDate: TaskyDate
    ) {
        LazyRow(modifier = Modifier.fillMaxWidth(), state = listState) {
            items(dateRange, key = { it.value.dayOfMonth }) { date ->
                SelectedMonthDatePickerItem(
                    date = date,
                    onClick = onDaySelected,
                    isSelected = date.value.dayOfMonth == selectedDate.value.dayOfMonth
                )
            }
        }
    }

    @Composable
    fun FloatingButton(onClick: () -> Unit) {
        UnifyFloatingButton(
            iconConfig = UnifyIconConfig(
                icon = UnifyIcons.Add,
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
                config = UnifyTextViewConfig(
                    textType = UnifyTextType.BodyMedium,
                    text = headerDate,
                    color = UnifyColors.White
                )
            )
            UnifyIcon(
                config = UnifyIconConfig(
                    icon = UnifyIcons.DropDown,
                    tint = UnifyColors.White
                )
            )
        }
    }

    @Composable
    private fun SelectedMonthDatePickerItem(
        date: TaskyDate,
        onClick: (TaskyDate) -> Unit,
        isSelected: Boolean
    ) = date.value.run {
        Column(
            modifier = Modifier
                .width(UnifyDimens.Dp_36)
                .height(UnifyDimens.Dp_50)
                .clip(RoundedCornerShape(UnifyDimens.Radius.Medium))
                .clickable { onClick(date) }
                .background(color = if (isSelected) UnifyColors.Orange100 else UnifyColors.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            UnifyTextView(
                config = UnifyTextViewConfig(
                    text = "${dayOfWeek.name[0]}",
                    textType = UnifyTextType.LabelMedium
                )
            )
            UnifyTextView(
                config = UnifyTextViewConfig(
                    text = "$dayOfMonth",
                    textType = UnifyTextType.TitleMedium
                )
            )
        }
    }
}