package pseudoankit.droid.coreui.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import pseudoankit.droid.coreui.components.icon.UnifyIcons
import pseudoankit.droid.coreui.components.textfield.UnifyTextFieldInternal.Label
import pseudoankit.droid.coreui.components.textfield.UnifyTextFieldInternal.LeadingIcon
import pseudoankit.droid.coreui.components.textfield.UnifyTextFieldInternal.TrailingIcon
import pseudoankit.droid.coreui.token.UnifyDimens

object UnifyTextField {
    data class Config(
        val value: String,
        val onValueChange: (String) -> Unit,
        val keyboardType: KeyboardType = KeyboardType.Text,
        val placeholder: String? = null,
        val leadingIcon: UnifyIcons? = null,
        val trailingIcon: Icon? = null,
        val errorMessage: String? = null,
        val modifier: Modifier = Modifier.fillMaxWidth(),
        val maxLines: Int = Int.MAX_VALUE
    )

    sealed interface Icon {
        object Valid : Icon
        object Password : Icon
        data class Custom(val icon: UnifyIcons, val onClick: () -> Unit) : Icon
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnifyTextField(config: UnifyTextField.Config) = config.apply {
    Column {
        var isTextHidden by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Done
            ),
            label = placeholder.Label(),
            leadingIcon = leadingIcon.LeadingIcon(),
            trailingIcon = trailingIcon.TrailingIcon(
                isTextHidden = isTextHidden,
                toggleIsTextHidden = {
                    isTextHidden = isTextHidden.not()
                }
            ),
            isError = errorMessage != null,
            singleLine = maxLines == 1,
            maxLines = maxLines,
            shape = RoundedCornerShape(UnifyDimens.Radius.Small),
            visualTransformation = if (isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
        )

        UnifyTextFieldInternal.ErrorMessage(errorMessage = errorMessage)
    }
}