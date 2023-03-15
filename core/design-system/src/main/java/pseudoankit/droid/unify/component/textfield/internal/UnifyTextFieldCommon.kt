package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object UnifyTextFieldCommon {

    fun UnifyTextFieldConfig.visualTransformation(isTextHidden: Boolean): VisualTransformation =
        when (trailingIcon) {
            is UnifyTextFieldConfig.TrailingIcon.Password -> {
                if (isTextHidden) PasswordVisualTransformation() else VisualTransformation.None
            }
            else -> VisualTransformation.None
        }

    @Composable
    fun UnifyTextFieldConfig.trailingIcon(
        isTextHidden: Boolean,
        text: String,
        onPasswordVisibilityToggled: () -> Unit,
        onClearText: () -> Unit,
    ): @Composable() (() -> Unit)? = if (trailingIcon != null) {
        {
            when (trailingIcon) {
                is UnifyTextFieldConfig.TrailingIcon.Custom -> UnifyIcon(
                    config = UnifyIconConfig(
                        tint = UnifyTextFieldTokens.Icon.Color,
                        size = UnifyTextFieldTokens.Icon.Size,
                        icon = trailingIcon.icon,
                        onClick = trailingIcon.onClick
                    )
                )
                is UnifyTextFieldConfig.TrailingIcon.Password -> {
                    if (text.isNotBlank()) {
                        UnifyIcon(
                            config = UnifyIconConfig(
                                tint = UnifyTextFieldTokens.Icon.Color,
                                size = UnifyTextFieldTokens.Icon.Size,
                                icon = if (isTextHidden) UnifyIcons.EyeOn else UnifyIcons.EyeOff,
                                onClick = onPasswordVisibilityToggled
                            )
                        )
                    }
                }
                is UnifyTextFieldConfig.TrailingIcon.Valid -> UnifyIcon(
                    config = UnifyIconConfig(
                        tint = UnifyColors.Green800,
                        size = UnifyTextFieldTokens.Icon.Size,
                        icon = UnifyIcons.Check
                    )
                )
                UnifyTextFieldConfig.TrailingIcon.Clear -> {
                    if (text.isNotBlank()) {
                        UnifyIcon(
                            config = UnifyIconConfig(
                                tint = UnifyColors.White,
                                size = 20.dp,
                                icon = UnifyIcons.Cross,
                                onClick = onClearText,
                                modifier = Modifier
                                    .size(UnifyTextFieldTokens.Icon.Size)
                                    .clip(CircleShape)
                                    .background(UnifyTextFieldTokens.Icon.Color)
                            )
                        )
                    }
                }
            }
        }
    } else null

    @Composable
    fun UnifyTextFieldConfig.leadingIcon(): @Composable() (() -> Unit)? =
        leadingIcon?.run {
            {
                UnifyIcon(
                    config = UnifyIconConfig(
                        tint = UnifyTextFieldTokens.Icon.Color,
                        size = UnifyTextFieldTokens.Icon.Size,
                        icon = this
                    )
                )
            }
        }

    @Composable
    fun UnifyTextFieldConfig.label(): @Composable() (() -> Unit)? = label?.run {
        {
            UnifyTextView(
                config = UnifyTextViewConfig(
                    text = this,
                    textType = UnifyTextType.LabelLarge,
                    color = UnifyColors.Gray800
                )
            )
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