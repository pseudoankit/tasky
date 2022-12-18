package pseudoankit.droid.coreui.model

import androidx.compose.runtime.Immutable
import java.time.LocalDate

@Immutable
data class TaskyDate(val date: LocalDate, val isSelected: Boolean = false)
