package pseudoankit.droid.coreui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

data class TaskyTextConfig(
    val text: String,
    val textType: TaskyTextType,
    val color: Color = Color.Unspecified,
    val textDecoration: TextDecoration? = null,
    val textAlign: TextAlign? = null,
    val maxLines: Int = Int.MAX_VALUE,
    val fontStyle: FontStyle? = null,
)

@Composable
fun TaskyText(config: TaskyTextConfig?) = config?.apply {
    Text(
        text = text,
        color = color,
        textDecoration = textDecoration,
        textAlign = textAlign,
        maxLines = maxLines,
        fontStyle = fontStyle,
        fontSize = textType.fontSize,
        fontWeight = textType.fontWeight,
        letterSpacing = textType.letterSpacing,
        lineHeight = textType.lineHeight,
    )
}