package pseudoankit.droid.coreui.components.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.*
import pseudoankit.droid.coreui.components.icon.TaskyIcon
import pseudoankit.droid.coreui.components.icon.TaskyIconButton
import pseudoankit.droid.coreui.components.icon.TaskyIconConfig
import pseudoankit.droid.coreui.components.icon.TaskyIcons
import pseudoankit.droid.coreui.components.text.TaskyText
import pseudoankit.droid.coreui.components.text.TaskyTextConfig
import pseudoankit.droid.coreui.components.text.TaskyTextType
import pseudoankit.droid.coreui.token.TaskyColor
import pseudoankit.droid.coreui.token.TaskyDimens
import pseudoankit.droid.coreui.util.asString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskyTextField(config: TaskyTextFieldConfig) = config.apply {
    var isTextHidden by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        label = placeholder?.run {
            {
                TaskyText(
                    config = TaskyTextConfig(
                        text = placeholder.asString(),
                        textType = TaskyTextType.BodyLarge,
                        color = TaskyColor.DarkGray
                    )
                )
            }
        },
        leadingIcon = leadingIcon?.run {
            {
                TaskyIcon(
                    config = TaskyIconConfig(
                        tint = TaskyColor.Gray,
                        size = TaskyDimens.Dp_24,
                        icon = leadingIcon
                    )
                )
            }
        },
        trailingIcon = trailingIcon?.run {
            {
                when (trailingIcon) {
                    is TaskyTextFieldConfig.Icon.Custom -> TaskyIconButton(
                        config = TaskyIconConfig(
                            tint = TaskyColor.Gray,
                            size = TaskyDimens.Dp_24,
                            icon = trailingIcon.icon,
                            onClick = trailingIcon.onClick
                        )
                    )
                    is TaskyTextFieldConfig.Icon.Password -> TaskyIconButton(
                        config = TaskyIconConfig(
                            tint = TaskyColor.Gray,
                            size = TaskyDimens.Dp_24,
                            icon = if (isTextHidden) TaskyIcons.EyeOn else TaskyIcons.EyeOff,
                            onClick = {
                                isTextHidden = isTextHidden.not()
                            }
                        )
                    )
                    is TaskyTextFieldConfig.Icon.Valid -> TaskyIcon(
                        config = TaskyIconConfig(
                            tint = TaskyColor.Green,
                            size = TaskyDimens.Dp_24,
                            icon = TaskyIcons.Check
                        )
                    )
                }
            }
        },
        isError = errorMessage != null,
        singleLine = maxLines == 1,
        maxLines = maxLines,
        shape = RoundedCornerShape(TaskyDimens.Radius.Small),
        visualTransformation = if (isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
    )
}