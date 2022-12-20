package pseudoankit.droid.unify.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

@OptIn(ExperimentalMaterial3Api::class)
internal object UnifyTextFieldInternal {

    @Composable
    operator fun invoke(config: UnifyTextField.Config) = config.apply {
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
                label = {
                    placeholder?.Label()
                },
                leadingIcon = {
                    leadingIcon?.LeadingIcon()
                },
                trailingIcon = {
                    if (trailingIcon != null && showTrailingIcon) {
                        trailingIcon.TrailingIcon(
                            isTextHidden = isTextHidden,
                            toggleIsTextHidden = {
                                isTextHidden = isTextHidden.not()
                            }
                        )
                    }
                },
                isError = errorMessage != null,
                singleLine = maxLines == 1,
                maxLines = maxLines,
                shape = RoundedCornerShape(UnifyDimens.Radius.Small),
                visualTransformation = if (isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
            )

            ErrorMessage(errorMessage = errorMessage)
        }
    }

    @Composable
    private fun UnifyTextField.Icon.TrailingIcon(
        isTextHidden: Boolean,
        toggleIsTextHidden: () -> Unit
    ) = when (this) {
        is UnifyTextField.Icon.Custom -> UnifyIcon(
            config = UnifyIcon.Config(
                tint = UnifyColors.Gray,
                size = UnifyDimens.Dp_24,
                icon = this.icon,
                onClick = this.onClick
            )
        )
        is UnifyTextField.Icon.Password -> UnifyIcon(
            config = UnifyIcon.Config(
                tint = UnifyColors.Gray,
                size = UnifyDimens.Dp_24,
                icon = if (isTextHidden) UnifyIcons.EyeOn else UnifyIcons.EyeOff,
                onClick = toggleIsTextHidden
            )
        )
        is UnifyTextField.Icon.Valid -> UnifyIcon(
            config = UnifyIcon.Config(
                tint = UnifyColors.Green,
                size = UnifyDimens.Dp_24,
                icon = UnifyIcons.Check
            )
        )
    }


    @Composable
    private fun UnifyIcons.LeadingIcon() = UnifyIcon(
        config = UnifyIcon.Config(
            tint = UnifyColors.Gray,
            size = UnifyDimens.Dp_24,
            icon = this
        )
    )

    @Composable
    private fun String.Label() = UnifyTextView(
        config = UnifyTextView.Config(
            text = this,
            textType = UnifyTextType.BodyLarge,
            color = UnifyColors.DarkGray
        )
    )

    @Composable
    private fun ErrorMessage(errorMessage: String?) {
        if (errorMessage == null) return

        Spacer(modifier = Modifier.height(UnifyDimens.Dp_2))
        UnifyTextView(
            config = UnifyTextView.Config(
                text = errorMessage,
                textType = UnifyTextType.BodySmall,
                color = UnifyColors.Error
            )
        )
    }
}