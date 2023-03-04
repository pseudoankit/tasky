package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.util.extension.asString
import pseudoankit.droid.tasky.reminder.presentation.mapper.RepeatIntervalUiMapper.label
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.list.UnifyListItemConfig
import pseudoankit.droid.unify.component.list.UnifyListItem
import pseudoankit.droid.unify.component.switch.UnifySwitchConfig
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldDefaults
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.component.topbar.UnifyTopBarConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object ReminderHomeScreenComponents {

    @Composable
    fun RepeatIntervalDialogItems(
        items: ImmutableList<AgendaItem.Reminder.RepeatInterval>,
        onClick: (AgendaItem.Reminder.RepeatInterval) -> Unit,
        selectedItem: AgendaItem.Reminder.RepeatInterval
    ) {
        Column(modifier = Modifier.padding(vertical = UnifyDimens.Dp_16)) {
            items.forEach { item ->
                UnifyListItem(
                    config = UnifyListItemConfig(
                        label = item.label.asString(),
                        trailingSection = if (item == selectedItem) UnifyListItemConfig.TrailingSection.NoAction(
                            UnifyIcons.Check
                        ) else null,
                        color = if (item == selectedItem) UnifyColors.Purple800 else UnifyColors.Black,
                        modifier = Modifier
                            .clickable { onClick(item) }
                            .padding(vertical = UnifyDimens.Dp_12, horizontal = UnifyDimens.Dp_16)
                    )
                )
            }
        }
    }

    @Composable
    fun RepeatsReminderAtText(repeatIntervalLabel: TextResource, onClick: () -> Unit) {
        UnifyListItem(
            config = UnifyListItemConfig(
                leadingIcon = UnifyIcons.Refresh,
                label = repeatIntervalLabel.asString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onClick)
                    .padding(UnifyDimens.Dp_16)
            )
        )
    }

    // TODO : clear focus from text field
    @Composable
    fun ReminderConfigurations(
        remindAllDay: Boolean,
        date: String,
        time: String?,
        onRemindAllDayToggled: () -> Unit,
        onDateClicked: () -> Unit,
        onTimeClicked: () -> Unit,
    ) = Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        RemindAllDayListItem(remindAllDay = remindAllDay, onClick = onRemindAllDayToggled)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = UnifyDimens.Dp_44, end = UnifyDimens.Dp_8),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Date(date = date, onClick = onDateClicked)
            Time(time = time, onClick = onTimeClicked)
        }
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_16))
    }

    @Composable
    fun TextField(
        value: String,
        onReminderTextFieldValueChanged: (String) -> Unit
    ) {
        UnifyTextField(
            config = UnifyTextFieldConfig(
                placeholder = UnifyTextFieldDefaults.placeHolder(
                    value = "Remind me to...",
                    textType = UnifyTextType.HeadlineSmall
                ),
                value = value,
                onValueChange = onReminderTextFieldValueChanged,
                type = UnifyTextFieldConfig.Type.Basic,
                textType = UnifyTextType.HeadlineSmall,
                focusState = UnifyTextFieldConfig.FocusState.Request,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = UnifyDimens.Dp_8, start = UnifyDimens.Dp_32)
            )
        )
    }

    fun topBarConfig(
        onNavigateUp: () -> Unit,
        onSave: () -> Unit,
    ) = UnifyTopBarConfig(
        leadingIcon = UnifyIconConfig(
            icon = UnifyIcons.Cross,
            onClick = onNavigateUp
        ),
        trailingSection = UnifyTopBarConfig.TrailingSection(
            text = UnifyTextViewConfig(
                text = "Save"
            ),
            icon = UnifyIconConfig(icon = UnifyIcons.CheckCircle),
            onClick = onSave
        )
    )

    @Composable
    private fun RemindAllDayListItem(remindAllDay: Boolean, onClick: () -> Unit) {
        UnifyListItem(
            config = UnifyListItemConfig(
                label = "All-day",
                leadingIcon = UnifyIcons.Clock,
                trailingSection = UnifyListItemConfig.TrailingSection.Switch(
                    value = UnifySwitchConfig(
                        checked = remindAllDay,
                        onCheckedChange = onClick
                    )
                ),
                color = UnifyColors.Black,
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .padding(horizontal = UnifyDimens.Dp_16)
            )
        )
    }

    @Composable
    private fun Time(time: String?, onClick: () -> Unit) {
        if (time == null) return

        UnifyTextView(
            config = UnifyTextViewConfig(
                textType = UnifyTextType.BodyLarge,
                text = time,
                color = UnifyColors.Black,
                modifier = Modifier
                    .clip(RoundedCornerShape(UnifyDimens.Radius.Small))
                    .clickable(onClick = onClick)
                    .padding(UnifyDimens.Dp_4)
            )
        )
    }

    @Composable
    private fun Date(date: String, onClick: () -> Unit) {
        UnifyTextView(
            config = UnifyTextViewConfig(
                textType = UnifyTextType.BodyLarge,
                text = date,
                color = UnifyColors.Black,
                modifier = Modifier
                    .clip(RoundedCornerShape(UnifyDimens.Radius.Small))
                    .clickable(onClick = onClick)
                    .padding(vertical = UnifyDimens.Dp_4, horizontal = UnifyDimens.Dp_8)
            )
        )
    }
}