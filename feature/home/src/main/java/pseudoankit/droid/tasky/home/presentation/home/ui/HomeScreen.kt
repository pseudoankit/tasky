package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.coreui.surface.HandleKoinModuleInit
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.coreui.surface.TaskyDestinationSurfaceConfig
import pseudoankit.droid.coreui.util.extension.state
import pseudoankit.droid.tasky.home.di.HomeModule
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.home.HomeUiState
import pseudoankit.droid.tasky.home.presentation.home.HomeViewModel
import pseudoankit.droid.unify.components.dialog.datepicker.UnifyDatePicker

@Destination
@Composable
internal fun HomeScreen(
    navigator: HomeScreenNavigator
) = HandleKoinModuleInit(module = HomeModule) {
    val viewModel = getViewModel<HomeViewModel>()

    val dateRangeListState = rememberLazyListState()
    HandleHomeScreenSideEffect(dateRangeListState = dateRangeListState, navigator = navigator)

    val state = viewModel.collectAsState().value

    TaskyDestinationSurface(
        config = TaskyDestinationSurfaceConfig(
            topBar = {
                HomeScreenComponents.TopBar(
                    headerDate = state.displayHeaderDate,
                    onMonthSelected = viewModel::onHeaderMonthSelected
                )
            },
            floatingActionButton = {
                HomeScreenComponents.FloatingButton(
                    isSelected = navigator.isAgendaItemsScreenVisible(),
                    onClick = viewModel::onShowAgendaItems
                )
            }
        )
    ) {
        HomeScreenComponents.SelectedMonthDatePicker(
            dateRange = state.selectedMonthDateRange,
            onDaySelected = viewModel::onDaySelected,
            listState = dateRangeListState
        )
    }
}

@Composable
private fun HandleHomeScreenSideEffect(
    viewModel: HomeViewModel = getViewModel(),
    dateRangeListState: LazyListState,
    navigator: HomeScreenNavigator
) {
    val datePicker = UnifyDatePicker(
        UnifyDatePicker.Config(
            initialDate = viewModel.state.selectedDate.value,
            onDateChanged = viewModel::onDateChanged
        )
    )

    LaunchedEffect(Unit) {
        viewModel.onInit()
        viewModel.container.sideEffectFlow.collectLatest {
            when (it) {
                HomeUiState.SideEffect.ShowDatePicker -> datePicker.show()
                is HomeUiState.SideEffect.HighlightCurrentSelectedDate -> {
                    dateRangeListState.animateScrollToItem(it.position)
                }
                HomeUiState.SideEffect.ShowAgendaItems -> navigator.navigateToAgendaItemsScreen()
            }
        }
    }
}
