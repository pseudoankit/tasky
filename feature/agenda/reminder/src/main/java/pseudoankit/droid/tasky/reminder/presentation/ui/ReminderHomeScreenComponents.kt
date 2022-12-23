package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
    @Composable
    fun ReminderConfigs(
        allDayReminderEnabled: Boolean,
        onAllDaySwitchClicked: (Boolean) -> Unit,
        date: String
    ) = Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(UnifyDimens.Dp_16)
    ) {
        UnifyList(config = remember(allDayReminderEnabled, onAllDaySwitchClicked) {
            UnifyList.Config(
                label = "All-day",
                leadingIcon = UnifyIcons.Clock,
                trailingIcon = UnifyList.TrailingIcon.Switch(
                    value = UnifySwitch.Config(
                        checked = allDayReminderEnabled,
                        onCheckedChange = onAllDaySwitchClicked
                    )
                ),
                color = UnifyColors.Black
            )
        })
        UnifyTextView(
            config = UnifyTextView.Config(
                textType = UnifyTextType.BodyLarge,
                text = date,
                color = UnifyColors.Black,
                modifier = Modifier.offset(x = UnifyDimens.Dp_36)
            )
        )
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
}