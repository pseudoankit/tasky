package pseudoankit.droid.coreui.destination

import androidx.compose.ui.window.DialogProperties
import com.ramcosta.composedestinations.spec.DestinationStyle

object TaskyDestinationStyle {

    object Dialog : DestinationStyle.Dialog {
        override val properties: DialogProperties
            get() = DialogProperties(
                usePlatformDefaultWidth = false
            )
    }
}