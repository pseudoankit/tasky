package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.list.UnifyList
import pseudoankit.droid.unify.components.switch.UnifySwitch
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textfield.UnifyTextFieldDefaults
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object ReminderHomeScreenComponents {

    // TODO : clear focus from text field
    @Composable
    fun ReminderConfigurations(
        remindAllDay: Boolean,
        date: String,
        time: String?,
        onRemindAllDayToggled: () -> Unit,
    ) = Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        RemindAllDayListItem(remindAllDay, onRemindAllDayToggled)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = UnifyDimens.Dp_44, end = UnifyDimens.Dp_8),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Date(date = date)
            Time(time = time)
        }
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_16))
    }

    @Composable
    fun TextField(
        value: String,
        onReminderTextFieldValueChanged: (String) -> Unit
    ) {
        UnifyTextField(
            config = UnifyTextField.Config(
                placeholder = UnifyTextFieldDefaults.placeHolder(
                    value = "Remind me to...",
                    textType = UnifyTextType.HeadlineSmall
                ),
                value = value,
                onValueChange = onReminderTextFieldValueChanged,
                type = UnifyTextField.Type.Basic,
                textType = UnifyTextType.HeadlineSmall,
                focusState = UnifyTextField.FocusState.Request,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = UnifyDimens.Dp_8, start = UnifyDimens.Dp_32)
            )
        )
    }

    @Composable
    private fun RemindAllDayListItem(remindAllDay: Boolean, onRemindAllDayToggled: () -> Unit) {
        UnifyList(
            config = UnifyList.Config(
                label = "All-day",
                leadingIcon = UnifyIcons.Clock,
                trailingIcon = UnifyList.TrailingIcon.Switch(
                    value = UnifySwitch.Config(
                        checked = remindAllDay,
                        onCheckedChange = onRemindAllDayToggled
                    )
                ),
                color = UnifyColors.Black,
                modifier = Modifier
                    .clickable(onClick = onRemindAllDayToggled)
                    .padding(horizontal = UnifyDimens.Dp_16)
            )
        )
    }

    @Composable
    private fun Time(time: String?) {
        if (time == null) return

        UnifyTextView(
            config = UnifyTextView.Config(
                textType = UnifyTextType.BodyLarge,
                text = time,
                color = UnifyColors.Black,
                modifier = Modifier
                    .clip(RoundedCornerShape(UnifyDimens.Radius.Small))
                    .clickable { }
                    .padding(UnifyDimens.Dp_4)
            )
        )
    }

    @Composable
    private fun Date(date: String) {
        UnifyTextView(
            config = UnifyTextView.Config(
                textType = UnifyTextType.BodyLarge,
                text = date,
                color = UnifyColors.Black,
                modifier = Modifier
                    .clip(RoundedCornerShape(UnifyDimens.Radius.Small))
                    .clickable { }
                    .padding(vertical = UnifyDimens.Dp_4, horizontal = UnifyDimens.Dp_8)
            )
        )
    }
}