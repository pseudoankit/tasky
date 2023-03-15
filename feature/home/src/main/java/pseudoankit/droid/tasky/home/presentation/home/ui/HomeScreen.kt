package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.coreui.koin.load
import pseudoankit.droid.coreui.util.extension.state
import pseudoankit.droid.tasky.home.di.HomeModule
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.home.HomeUiState
import pseudoankit.droid.tasky.home.presentation.home.HomeViewModel
import pseudoankit.droid.unify.component.dialog.datepicker.UnifyDatePicker
import pseudoankit.droid.unify.component.dialog.datepicker.UnifyDatePickerConfig
import pseudoankit.droid.unify.component.dialog.rememberUnifyDialogState
import pseudoankit.droid.unify.screen.UnifyScreen
import pseudoankit.droid.unify.screen.UnifyScreenConfig
import pseudoankit.droid.unify.token.UnifyDimens

@Destination
@Composable
internal fun HomeScreen(
    navigator: HomeScreenNavigator
) = HomeModule.load {
    val viewModel = getViewModel<HomeViewModel>()

    val dateRangeListState = rememberLazyListState()
    HandleHomeScreenSideEffect(dateRangeListState = dateRangeListState, navigator = navigator)

    val state = viewModel.collectAsState().value

    UnifyScreen(
        config = UnifyScreenConfig(
            topBar = {
                HomeScreenComponents.TopBar(
                    headerDate = state.displayHeaderDate,
                    onMonthSelected = viewModel::onHeaderMonthSelected,
                    onProfileIconClicked = viewModel::onProfileIconClicked
                )
            },
            floatingActionButton = {
                HomeScreenComponents.FloatingButton(
                    onClick = viewModel::onShowAgendaItems
                )
            }
        ),
        singleEvents = {
            viewModel.highlightCurrentSelectedDate()
        }
    ) {
        ShowBannerAndRequestIfNotificationPermissionDenied()
        Spacer(modifier = Modifier.height(16.dp))
        HomeScreenComponents.SelectedMonthDatePicker(
            dateRange = state.selectedMonthDateRange,
            onDaySelected = viewModel::onDateChanged,
            listState = dateRangeListState,
            selectedDate = state.selectedDate
        )
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_16))
        HomeScreenComponents.SavedAgendaItems(
            items = state.savedAgendaItems,
            onItemCompletionToggled = viewModel::onAgendaItemCompletionToggle,
            onEdit = viewModel::onEditAgendaItem,
            onDelete = viewModel::onDeleteAgendaItem
        )
    }
}

@Composable
private fun HandleHomeScreenSideEffect(
    dateRangeListState: LazyListState,
    navigator: HomeScreenNavigator,
    viewModel: HomeViewModel = getViewModel(),
) {
    val datePicker = rememberUnifyDialogState()
    UnifyDatePicker(
        config = UnifyDatePickerConfig(
            initialDate = viewModel.state.selectedDate.value,
        ),
        datePickerState = datePicker,
        onDateChanged = viewModel::onDateChanged,
    )

    LaunchedEffect(Unit) {
        viewModel.container.sideEffectFlow.collectLatest {
            when (it) {
                HomeUiState.SideEffect.ShowDatePicker -> datePicker.show()
                is HomeUiState.SideEffect.HighlightCurrentSelectedDate -> {
                    dateRangeListState.animateScrollToItem(it.position)
                }
                HomeUiState.SideEffect.ShowAgendaItems -> {
                    navigator.navigateToAgendaItemsSelectorScreen()
                }
                is HomeUiState.SideEffect.NavigateToAgendaScreen -> {
                    navigator.navigateToAgendaScreen(it.agendaTypes)
                }
                HomeUiState.SideEffect.ShowProfileIcon -> {
                    navigator.navigateToProfileScreen()
                }
            }
        }
    }
}
