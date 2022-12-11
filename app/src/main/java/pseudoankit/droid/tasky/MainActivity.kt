package pseudoankit.droid.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.util.TaskyColor
import pseudoankit.droid.coreui.util.TaskyTheme
import pseudoankit.droid.navigation.NavigateToLogin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = TaskyColor.White
                ) {
                    NavigateToLogin()
                }
            }
        }
    }
}
