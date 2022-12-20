package pseudoankit.droid.unify.components.textview

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

private val typography by lazy {
    androidx.compose.material3.Typography()
}

enum class UnifyTextType(val textStyle: TextStyle) {
    DisplayLarge(typography.displayLarge),
    DisplayMedium(typography.displayMedium),
    DisplaySmall(typography.displaySmall),
    HeadlineLarge(typography.headlineLarge),
    HeadlineMedium(typography.headlineMedium),
    HeadlineSmall(typography.headlineSmall),
    TitleLarge(typography.titleLarge.copy(fontWeight = FontWeight.Bold)),
    TitleMedium(typography.titleMedium.copy(fontWeight = FontWeight.Bold)),
    TitleSmall(typography.titleSmall.copy(fontWeight = FontWeight.Bold)),
    BodyLarge(typography.bodyLarge),
    BodyMedium(typography.bodyMedium),
    BodySmall(typography.bodySmall),
    LabelLarge(typography.labelLarge),
    LabelMedium(typography.labelMedium),
    LabelSmall(typography.labelSmall)
}