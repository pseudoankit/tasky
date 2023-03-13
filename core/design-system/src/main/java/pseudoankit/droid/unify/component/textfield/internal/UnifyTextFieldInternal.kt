package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import kotlinx.coroutines.delay
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.label
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.leadingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.trailingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.visualTransformation
import pseudoankit.droid.unify.token.UnifyDimens

@Composable
internal fun UnifyOutlinedTextField(config: UnifyTextFieldConfig) = with(config) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = label(),
            leadingIcon = leadingIcon(),
            trailingIcon = trailingIcon(),
            isError = errorMessage != null,
            singleLine = maxLines == 1,
            maxLines = maxLines,
            shape = UnifyTextFieldTokens.Background.shape(type = type),
            visualTransformation = visualTransformation(),
            textStyle = textType.textStyle,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )

        UnifyTextFieldCommon.ErrorMessage(errorMessage = errorMessage)
    }
}
