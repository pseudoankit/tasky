package pseudoankit.droid.app_shortcuts.widget.ui

import androidx.lifecycle.ViewModel
import pseudoankit.droid.agendamanger.domain.usecase.reminder.GetSavedAgendaItemsUseCase

class WidgetViewModel(
    private val getSavedAgendaItemsUseCase: GetSavedAgendaItemsUseCase
) : ViewModel() {

}