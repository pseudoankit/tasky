package pseudoankit.droid.coreui.components.text

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

enum class UnifyTextType(
    val fontSize: TextUnit = TextUnit.Unspecified,
    val fontWeight: FontWeight? = null,
    val letterSpacing: TextUnit = TextUnit.Unspecified,
    val lineHeight: TextUnit = TextUnit.Unspecified,
) {

    TitleLarge(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),
    TitleMedium(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
    ),
    LabelLarge(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
    ),
    LabelMedium(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),
    LabelSmall(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
    BodyLarge(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.5.sp
    )
}