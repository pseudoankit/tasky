package pseudoankit.droid.tasky.home.presentation

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.surface.CoreKoinComposable
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.tasky.home.di.HomeModule
import pseudoankit.droid.tasky.home.navigator.HomeNavigator

@Destination
@Composable
internal fun HomeScreen(navigator: HomeNavigator) = CoreKoinComposable(module = HomeModule) {
    val viewModel = getViewModel<HomeViewModel>()

    TaskyDestinationSurface {
        
    }
}
