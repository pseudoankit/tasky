package pseudoankit.droid.coreui.components.text

import androidx.compose.ui.text.TextStyle

private val typography = androidx.compose.material3.Typography()

enum class UnifyTextType(val textStyle: TextStyle) {
    DisplayLarge(typography.displayLarge),
    DisplayMedium(typography.displayMedium),
    DisplaySmall(typography.displaySmall),
    HeadlineLarge(typography.headlineLarge),
    HeadlineMedium(typography.headlineMedium),
    HeadlineSmall(typography.headlineSmall),
    TitleLarge(typography.titleLarge),
    TitleMedium(typography.titleMedium),
    TitleSmall(typography.titleSmall),
    BodyLarge(typography.bodyLarge),
    BodyMedium(typography.bodyMedium),
    BodySmall(typography.bodySmall),
    LabelLarge(typography.labelLarge),
    LabelMedium(typography.labelMedium),
    LabelSmall(typography.labelSmall),

}