package pseudoankit.droid.unify.components.textfield.internal

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import pseudoankit.droid.unify.components.textfield.UnifyTextField
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.Label
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.LeadingIcon
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.TrailingIcon
import pseudoankit.droid.unify.components.textfield.internal.UnifyTextFieldCommon.visualTransformation
import pseudoankit.droid.unify.token.UnifyDimens

internal object UnifyBasicTextField {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    operator fun invoke(config: UnifyTextField.Config) = config.apply {
        TextField(
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
            colors = object : TextFieldColors {
                override val selectionColors: TextSelectionColors
                    @Composable get() = TODO("Not yet implemented")

                @Composable
                override fun containerColor(enabled: Boolean): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun cursorColor(isError: Boolean): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun indicatorColor(
                    enabled: Boolean,
                    isError: Boolean,
                    interactionSource: InteractionSource
                ): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun labelColor(
                    enabled: Boolean,
                    isError: Boolean,
                    interactionSource: InteractionSource
                ): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun leadingIconColor(
                    enabled: Boolean,
                    isError: Boolean,
                    interactionSource: InteractionSource
                ): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun placeholderColor(enabled: Boolean): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun textColor(enabled: Boolean): State<Color> {
                    TODO("Not yet implemented")
                }

                @Composable
                override fun trailingIconColor(
                    enabled: Boolean,
                    isError: Boolean,
                    interactionSource: InteractionSource
                ): State<Color> {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}