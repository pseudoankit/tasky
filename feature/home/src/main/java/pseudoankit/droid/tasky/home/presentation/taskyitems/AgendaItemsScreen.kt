package pseudoankit.droid.tasky.home.presentation.taskyitems

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.coreui.destination.TaskyDestinationStyle
import pseudoankit.droid.coreui.util.extension.asString
import pseudoankit.droid.tasky.home.navigator.HomeScreenNavigator
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaTypesUiMapper.icon
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaTypesUiMapper.label
import pseudoankit.droid.unify.component.fab.UnifyFloatingButton
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens
import pseudoankit.droid.unify.utils.clickable

@Destination(style = TaskyDestinationStyle.Dialog::class)
@Composable
internal fun AgendaItemsScreen(
    navigator: HomeScreenNavigator
) {
    val viewModel = getViewModel<AgendaItemsViewModel>()
    HandleSideEffect(navigator = navigator)

    val state = viewModel.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = viewModel::onNavigateUp, showRipple = false)
            .padding(UnifyDimens.ScreenPadding),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        AgendaItems(onAgendaSelected = viewModel::onAgendaSelected, items = state.items)
    }
}

@Composable
private fun AgendaItems(
    onAgendaSelected: (AgendaTypes) -> Unit,
    items: ImmutableList<AgendaTypes>
) {
    items.forEach {
        Spacer(modifier = Modifier.height(UnifyDimens.Dp_8))
        Row(verticalAlignment = Alignment.CenterVertically) {
            AgendaItem(it, onAgendaSelected)
        }
    }
}

@Composable
private fun AgendaItem(agenda: AgendaTypes, onAgendaSelected: (AgendaTypes) -> Unit) {
    UnifyTextView(
        config = UnifyTextViewConfig(
            text = agenda.label.asString(),
            textType = UnifyTextType.TitleMedium,
            color = UnifyColors.White,
            fontStyle = FontStyle.Italic
        )
    )
    Spacer(modifier = Modifier.width(UnifyDimens.Dp_8))
    UnifyFloatingButton(
        iconConfig = UnifyIconConfig(icon = agenda.icon),
        onClick = {
            onAgendaSelected(agenda)
        }
    )
}

@Composable
private fun HandleSideEffect(
    navigator: HomeScreenNavigator,
    viewModel: AgendaItemsViewModel = getViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.container.sideEffectFlow.collectLatest {
            when (it) {
                is AgendaItemsUiState.SideEffect.NavigateToAgenda -> {
                    navigator.navigateToAgendaScreen(it.type)
                }
                AgendaItemsUiState.SideEffect.NavigateUp -> navigator.navigateUp()
            }
        }
    }
}