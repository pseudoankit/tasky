package pseudoankit.droid.unify.components.textfield.internal

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.Label
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.LeadingIcon
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.TrailingIcon
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.visualTransformation
import pseudoankit.droid.unify.token.UnifyDimens

internal object UnifyBasicTextField {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    operator fun invoke(config: UnifyTextField.Config) = config.apply {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Done
            ),
            placeholder = Label(),
            leadingIcon = LeadingIcon(),
            trailingIcon = TrailingIcon(),
            isError = errorMessage != null,
            singleLine = maxLines == 1,
            maxLines = maxLines,
            shape = RoundedCornerShape(UnifyDimens.Radius.Small),
            visualTransformation = visualTransformation(),
            textStyle = textType.textStyle,
            colors = UnifyTextFieldCommon.textFieldColors()
        )
    }
}