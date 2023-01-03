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
import androidx.compose.ui.text.style.TextDecoration
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.coreui.util.extension.noRippleClickable
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.backgroundColor
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.displayDateTime
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.tint
import pseudoankit.droid.unify.components.card.UnifyCard
import pseudoankit.droid.unify.components.checkbox.UnifyCheckBox
import pseudoankit.droid.unify.components.fab.UnifyFloatingButton
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object HomeScreenComponents {

    @Composable
    fun SavedAgendaItems(
        items: ImmutableList<AgendaItem>,
        onItemCompletionToggled: (AgendaItem) -> Unit,
        onOptionClicked: (AgendaItem) -> Unit
    ) {
        LazyColumn {
            items(items) {
                SavedAgendaItem(it, onItemCompletionToggled, onOptionClicked)
                Spacer(modifier = Modifier.height(UnifyDimens.Dp_16))
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
        onDaySelected: (TaskyDate) -> Unit
    ) {
        LazyRow(modifier = Modifier.fillMaxWidth(), state = listState) {
            items(dateRange, key = { it.value.dayOfMonth }) { date ->
                SelectedMonthDatePickerItem(
                    date = date,
                    onClick = onDaySelected
                )
            }
        }
    }

    @Composable
    fun FloatingButton(onClick: () -> Unit) {
        UnifyFloatingButton(
            iconConfig = UnifyIcon.Config(
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
    ) = date.value.run {
        Column(
            modifier = Modifier
                .width(UnifyDimens.Dp_36)
                .height(UnifyDimens.Dp_50)
                .clip(RoundedCornerShape(UnifyDimens.Radius.Medium))
                .clickable { onClick(date) }
                .background(color = if (date.isSelected) UnifyColors.Orange100 else UnifyColors.White),
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

    @Composable
    private fun SavedAgendaItem(
        agendaItem: AgendaItem,
        onAgendaItemCompletionToggled: (AgendaItem) -> Unit,
        onOptionClicked: (AgendaItem) -> Unit
    ) = UnifyCard {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = agendaItem.backgroundColor)
                .padding(
                    bottom = UnifyDimens.Dp_12,
                    start = UnifyDimens.Dp_16,
                    end = UnifyDimens.Dp_16,
                    top = UnifyDimens.Dp_16
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(modifier = Modifier.weight(.93f), verticalAlignment = Alignment.Bottom) {
                    UnifyCheckBox(
                        UnifyCheckBox.Config(
                            checked = agendaItem.completed,
                            onCheckedChange = {
                                onAgendaItemCompletionToggled(agendaItem)
                            }
                        )
                    )
                    UnifyTextView(
                        UnifyTextView.Config(
                            text = agendaItem.title,
                            textType = UnifyTextType.TitleMedium,
                            color = agendaItem.tint,
                            textDecoration = if (agendaItem.completed) TextDecoration.LineThrough else TextDecoration.None,
                            maxLines = 1,
                            modifier = Modifier.offset(x = UnifyDimens.Dp_8)
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(.07f))
                UnifyIcon(
                    config = UnifyIcon.Config(
                        icon = UnifyIcons.EllipsisV,
                        tint = UnifyColors.White,

                        )
                )
            }
            UnifyTextView(
                UnifyTextView.Config(
                    text = "Description.....",
                    textType = UnifyTextType.BodyLarge,
                    color = agendaItem.tint,
                    modifier = Modifier.offset(x = UnifyDimens.Dp_32)
                )
            )
            UnifyTextView(
                UnifyTextView.Config(
                    text = agendaItem.displayDateTime,
                    textType = UnifyTextType.BodySmall,
                    color = agendaItem.tint,
                    modifier = Modifier.align(Alignment.End)
                )
            )
        }
    }
}