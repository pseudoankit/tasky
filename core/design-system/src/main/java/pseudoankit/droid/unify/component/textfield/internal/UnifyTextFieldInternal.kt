package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.label
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.leadingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.trailingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.visualTransformation
import pseudoankit.droid.unify.utils.internal.rememberMutableState

@Composable
internal fun UnifyOutlinedTextField(config: UnifyTextFieldConfig) = with(config) {
    var isTextHidden by rememberMutableState(false)

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = label(),
            leadingIcon = leadingIcon(),
            trailingIcon = trailingIcon(
                isTextHidden = isTextHidden,
                onPasswordVisibilityToggled = {
                    isTextHidden = isTextHidden.not()
                },
                text = value,
                onClearText = {
                    onValueChange("")
                }
            ),
            isError = errorMessage != null,
            singleLine = maxLines == 1,
            maxLines = maxLines,
            shape = UnifyTextFieldTokens.Background.shape(type = type),
            visualTransformation = visualTransformation(isTextHidden),
            textStyle = textType.textStyle,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )

        UnifyTextFieldCommon.ErrorMessage(errorMessage = errorMessage)
    }
}
