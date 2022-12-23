package pseudoankit.droid.tasky.reminder.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textfield.UnifyTextFieldDefaults
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.token.UnifyDimens

internal object ReminderHomeScreenComponents {
    private val ReminderOffset = UnifyDimens.Dp_24

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
                    .padding(end = UnifyDimens.Dp_4, start = ReminderOffset)
            )
        )
    }
}