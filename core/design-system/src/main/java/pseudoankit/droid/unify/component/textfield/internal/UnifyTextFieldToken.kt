package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.internal.rememberMutableState

internal object UnifyTextFieldToken {


    @Composable
    fun textFieldColors() = object : TextFieldColors {
        val defaultColors = TextFieldDefaults.textFieldColors()

        override val selectionColors: TextSelectionColors
            @Composable get() = defaultColors.selectionColors

        @Composable
        override fun containerColor(enabled: Boolean): State<Color> {
            return rememberMutableState(value = UnifyColors.White)
        }

        @Composable
        override fun cursorColor(isError: Boolean): State<Color> {
            return defaultColors.cursorColor(isError = isError)
        }

        @Composable
        override fun indicatorColor(
            enabled: Boolean,
            isError: Boolean,
            interactionSource: InteractionSource
        ): State<Color> {
            return rememberMutableState(value = UnifyColors.White)
        }

        @Composable
        override fun labelColor(
            enabled: Boolean,
            isError: Boolean,
            interactionSource: InteractionSource
        ): State<Color> {
            return defaultColors.labelColor(
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource
            )
        }

        @Composable
        override fun leadingIconColor(
            enabled: Boolean,
            isError: Boolean,
            interactionSource: InteractionSource
        ): State<Color> {
            return defaultColors.leadingIconColor(
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource
            )
        }

        @Composable
        override fun placeholderColor(enabled: Boolean): State<Color> {
            return defaultColors.placeholderColor(enabled = enabled)
        }

        @Composable
        override fun textColor(enabled: Boolean): State<Color> {
            return defaultColors.textColor(enabled = enabled)
        }

        @Composable
        override fun trailingIconColor(
            enabled: Boolean,
            isError: Boolean,
            interactionSource: InteractionSource
        ): State<Color> {
            return defaultColors.trailingIconColor(
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource
            )
        }
    }
}