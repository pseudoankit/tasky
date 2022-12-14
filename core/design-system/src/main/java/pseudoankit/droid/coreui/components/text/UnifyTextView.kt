package pseudoankit.droid.coreui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

object UnifyTextView {
    data class Config(
        val text: String,
        val textType: UnifyTextType,
        val color: Color = Color.Unspecified,
        val textDecoration: TextDecoration? = null,
        val textAlign: TextAlign? = null,
        val maxLines: Int = Int.MAX_VALUE,
        val fontStyle: FontStyle? = null,
        val modifier: Modifier = Modifier
    )
}

@Composable
fun UnifyTextView(config: UnifyTextView.Config?) = config?.apply {
    Text(
        text = text,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        maxLines = maxLines,
        fontStyle = fontStyle,
        style = textType.textStyle,
        modifier = modifier
    )
}