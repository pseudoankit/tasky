package pseudoankit.droid.unify.components.textfield.internal

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object UnifyTextFieldCommon {

    fun UnifyTextField.Config.visualTransformation(): VisualTransformation = when (trailingIcon) {
        is UnifyTextField.TrailingIcon.Password -> {
            if (trailingIcon.isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
        }
        else -> VisualTransformation.None
    }

    @Composable
    fun UnifyTextField.Config.TrailingIcon(): @Composable() (() -> Unit)? =
        takeIf { trailingIcon != null && showTrailingIcon }?.run {
            {
                when (trailingIcon) {
                    is UnifyTextField.TrailingIcon.Custom -> UnifyIcon(
                        config = UnifyIcon.Config(
                            tint = UnifyColors.Gray,
                            size = UnifyDimens.Dp_24,
                            icon = trailingIcon.icon,
                            onClick = trailingIcon.onClick
                        )
                    )
                    is UnifyTextField.TrailingIcon.Password -> UnifyIcon(
                        config = UnifyIcon.Config(
                            tint = UnifyColors.Gray,
                            size = UnifyDimens.Dp_24,
                            icon = if (trailingIcon.isTextHidden) UnifyIcons.EyeOn else UnifyIcons.EyeOff,
                            onClick = trailingIcon.onVisibilityToggled
                        )
                    )
                    is UnifyTextField.TrailingIcon.Valid -> UnifyIcon(
                        config = UnifyIcon.Config(
                            tint = UnifyColors.Green,
                            size = UnifyDimens.Dp_24,
                            icon = UnifyIcons.Check
                        )
                    )
                    null -> {}
                }
            }
        }

    @Composable
    fun UnifyTextField.Config.LeadingIcon(): @Composable() (() -> Unit)? =
        leadingIcon?.run {
            {
                UnifyIcon(
                    config = UnifyIcon.Config(
                        tint = UnifyColors.Gray,
                        size = UnifyDimens.Dp_24,
                        icon = this
                    )
                )
            }
        }

    @Composable
    fun UnifyTextField.Config.Label(): @Composable() (() -> Unit)? = placeholder?.run {
        {
            UnifyTextView(
                config = UnifyTextView.Config(
                    text = this,
                    textType = UnifyTextType.BodyLarge,
                    color = UnifyColors.DarkGray
                )
            )
        }
    }

    @Composable
    fun ErrorMessage(errorMessage: String?) {
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