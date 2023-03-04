package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.UnifyTextField
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens
import pseudoankit.droid.unify.token.UnifyTokens

internal object UnifyTextFieldCommon {

    fun UnifyTextFieldConfig.visualTransformation(): VisualTransformation = when (trailingIcon) {
        is UnifyTextFieldConfig.TrailingIcon.Password -> {
            if (trailingIcon.isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
        }
        else -> VisualTransformation.None
    }

    @Composable
    fun UnifyTextFieldConfig.TrailingIcon(): @Composable() (() -> Unit)? =
        takeIf { trailingIcon != null && showTrailingIcon }?.run {
            {
                when (trailingIcon) {
                    is UnifyTextFieldConfig.TrailingIcon.Custom -> UnifyIcon(
                        config = UnifyIconConfig(
                            tint = UnifyTokens.TextField.Icon.Color,
                            size = UnifyTokens.TextField.Icon.Size,
                            icon = trailingIcon.icon,
                            onClick = trailingIcon.onClick
                        )
                    )
                    is UnifyTextFieldConfig.TrailingIcon.Password -> UnifyIcon(
                        config = UnifyIconConfig(
                            tint = UnifyTokens.TextField.Icon.Color,
                            size = UnifyTokens.TextField.Icon.Size,
                            icon = if (trailingIcon.isTextHidden) UnifyIcons.EyeOn else UnifyIcons.EyeOff,
                            onClick = trailingIcon.onVisibilityToggled
                        )
                    )
                    is UnifyTextFieldConfig.TrailingIcon.Valid -> UnifyIcon(
                        config = UnifyIconConfig(
                            tint = UnifyColors.Green800,
                            size = UnifyTokens.TextField.Icon.Size,
                            icon = UnifyIcons.Check
                        )
                    )
                    null -> {}
                }
            }
        }

    @Composable
    fun UnifyTextFieldConfig.LeadingIcon(): @Composable() (() -> Unit)? =
        leadingIcon?.run {
            {
                UnifyIcon(
                    config = UnifyIconConfig(
                        tint = UnifyTokens.TextField.Icon.Color,
                        size = UnifyTokens.TextField.Icon.Size,
                        icon = this
                    )
                )
            }
        }

    @Composable
    fun UnifyTextFieldConfig.Label(): @Composable() (() -> Unit)? = placeholder?.run {
        {
            UnifyTextView(config = this)
        }
    }

    @Composable
    fun ErrorMessage(errorMessage: String?) {
        if (errorMessage == null) return

        Spacer(modifier = Modifier.height(UnifyDimens.Dp_2))
        UnifyTextView(
            config = UnifyTextViewConfig(
                text = errorMessage,
                textType = UnifyTextType.BodySmall,
                color = UnifyColors.Error
            )
        )
    }

}