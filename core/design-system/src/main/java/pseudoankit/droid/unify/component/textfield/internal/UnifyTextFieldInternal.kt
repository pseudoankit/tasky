package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import kotlinx.coroutines.delay
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.Label
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.LeadingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.TrailingIcon
import pseudoankit.droid.unify.component.textfield.internal.UnifyTextFieldCommon.visualTransformation
import pseudoankit.droid.unify.token.UnifyDimens

object UnifyTextFieldInternal {

    @Composable
    fun ManageFocus(focusState: UnifyTextFieldConfig.FocusState, focusRequester: FocusRequester) {
        val keyboard = LocalSoftwareKeyboardController.current

        LaunchedEffect(focusState) {
            when (focusState) {
                UnifyTextFieldConfig.FocusState.Request -> {
                    focusRequester.requestFocus()
                    delay(100)
                    keyboard?.show()
                }
                UnifyTextFieldConfig.FocusState.Capture -> focusRequester.captureFocus()
                UnifyTextFieldConfig.FocusState.Free -> {
                    focusRequester.freeFocus()
                    delay(100)
                    keyboard?.hide()
                }
                UnifyTextFieldConfig.FocusState.None -> {}
            }
        }
    }
}

@Composable
fun UnifyOutlinedTextField(config: UnifyTextFieldConfig) = with(config) {
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

        UnifyTextFieldCommon.ErrorMessage(errorMessage = errorMessage)
    }
}

@Composable
internal fun UnifyBasicTextField(config: UnifyTextFieldConfig) = with(config) {
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
        colors = UnifyTextFieldToken.textFieldColors()
    )
}