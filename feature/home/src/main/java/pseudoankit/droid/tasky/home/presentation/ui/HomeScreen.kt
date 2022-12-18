package pseudoankit.droid.tasky.home.presentation.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.components.datepicker.UnifyDatePicker
import pseudoankit.droid.coreui.components.datepicker.rememberUnifyDatePickerState
import pseudoankit.droid.coreui.surface.CoreKoinComposable
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.tasky.home.di.HomeModule
import pseudoankit.droid.tasky.home.navigator.HomeNavigator
import pseudoankit.droid.tasky.home.presentation.HomeUiState
import pseudoankit.droid.tasky.home.presentation.HomeViewModel

@Destination
@Composable
internal fun HomeScreen(navigator: HomeNavigator) = CoreKoinComposable(module = HomeModule) {
    val viewModel = getViewModel<HomeViewModel>()

    val dateRangeListState = rememberLazyListState()
    val state = viewModel.state

    HandleHomeScreenSideEffect(dateRangeListState = dateRangeListState)
    TaskyDestinationSurface(
        topBar = HomeScreenComponents.TopBar(
            month = state.selectedDate.date.month.toString(),
            onMonthSelected = viewModel::onHeaderMonthSelected
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
    dateRangeListState: LazyListState
) {
    val datePickerState = rememberUnifyDatePickerState()
    UnifyDatePicker(
        initialDate = viewModel.state.selectedDate.date,
        onDateSelected = viewModel::onDialogDateSelected,
        datePickerState = datePickerState
    )

    LaunchedEffect(Unit) {
        viewModel.onInit()
        viewModel.sideEffect.collect {
            when (it) {
                HomeUiState.SideEffect.ShowDatePickerDialog -> datePickerState.show()
                HomeUiState.SideEffect.HighlightCurrentSelectedDate ->
                    dateRangeListState.animateScrollToItem(viewModel.state.selectedDate.date.dayOfMonth - 1)
            }
        }
    }
}
