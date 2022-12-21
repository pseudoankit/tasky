package pseudoankit.droid.tasky.home.presentation.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.getViewModel
import pseudoankit.droid.coreui.surface.HandleKoinModuleInit
import pseudoankit.droid.coreui.surface.TaskyDestinationSurface
import pseudoankit.droid.tasky.home.di.HomeModule
import pseudoankit.droid.tasky.home.navigator.HomeNavigator
import pseudoankit.droid.tasky.home.presentation.HomeUiState
import pseudoankit.droid.tasky.home.presentation.HomeViewModel
import pseudoankit.droid.unify.components.datepicker.UnifyDatePicker
import pseudoankit.droid.unify.components.datepicker.rememberUnifyDatePickerState

@Destination
@Composable
internal fun HomeScreen(navigator: HomeNavigator) = HandleKoinModuleInit(module = HomeModule) {
    val viewModel = getViewModel<HomeViewModel>()

    val dateRangeListState = rememberLazyListState()
    HandleHomeScreenSideEffect(dateRangeListState = dateRangeListState)

    val state = viewModel.state

    HomeScreenComponents.AgendaItems(
        show = state.showAgendaItems,
        onDismiss = viewModel::onAgendaItemsVisibilityToggled,
        onAgendaSelected = viewModel::onAgendaSelected
    )
    TaskyDestinationSurface(
        topBar = {
            HomeScreenComponents.TopBar(
                headerDate = state.displayHeaderDate,
                onMonthSelected = viewModel::onHeaderMonthSelected
            )
        },
        floatingActionButton = {
            HomeScreenComponents.FloatingButton(
                isSelected = state.showAgendaItems,
                onClick = viewModel::onAgendaItemsVisibilityToggled
            )
        }
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
                is HomeUiState.SideEffect.HighlightCurrentSelectedDate ->
                    dateRangeListState.animateScrollToItem(it.position)
            }
        }
    }
}
