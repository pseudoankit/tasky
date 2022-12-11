package pseudoankit.droid.coreui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import pseudoankit.droid.coreui.components.icon.TaskyIcon
import pseudoankit.droid.coreui.components.icon.TaskyIconConfig
import pseudoankit.droid.coreui.token.TaskyDimens

data class TaskyTextFieldConfig(
    val value: String,
    val onValueChange: (String) -> Unit,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val imeAction: ImeAction = ImeAction.Done,
    val placeholder: String = "",
    val leadingIconConfig: TaskyIconConfig? = null,
    val trailingIconConfig: TaskyIconConfig? = null,
    val isError: Boolean = false,
    val maxLines: Int = Int.MAX_VALUE,
    val modifier: Modifier = Modifier.fillMaxWidth(),
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    val keyboardActions: KeyboardActions = KeyboardActions.Default,
    val isTextHidden: Boolean = false
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskyTextField(config: TaskyTextFieldConfig) = config.apply {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            leadingIconConfig?.apply {
                TaskyIcon(config = leadingIconConfig)
            }
        },
        trailingIcon = {
            trailingIconConfig?.apply {
                TaskyIcon(config = trailingIconConfig)
            }
        },
        isError = isError,
        singleLine = maxLines == 1,
        maxLines = maxLines,
        shape = RoundedCornerShape(TaskyDimens.Radius.Small),
        visualTransformation = if (isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
    )
}