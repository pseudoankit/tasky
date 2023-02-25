package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.ImeAction
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.ErrorMessage
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.Label
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.LeadingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.TrailingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.visualTransformation
import pseudoankit.droid.unify.token.UnifyDimens

@OptIn(ExperimentalMaterial3Api::class)
internal object UnifyOutlinedTextField {

    @Composable
    operator fun invoke(config: UnifyTextField.Config) = config.apply {
        Column {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = ImeAction.Done
                ),
                label = Label(),
                leadingIcon = LeadingIcon(),
                trailingIcon = TrailingIcon(),
                isError = errorMessage != null,
                singleLine = maxLines == 1,
                maxLines = maxLines,
                shape = RoundedCornerShape(UnifyDimens.Radius.Small),
                visualTransformation = visualTransformation(),
                textStyle = textType.textStyle,
            )

            ErrorMessage(errorMessage = errorMessage)
        }
    }
}