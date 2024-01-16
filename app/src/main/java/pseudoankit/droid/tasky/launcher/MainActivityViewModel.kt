package pseudoankit.droid.tasky.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

class MainActivityViewModel : ViewModel(),
    ContainerHost<MainActivityViewModel.State, MainActivityViewModel.SideEffect> {

    override val container: Container<State, SideEffect> = viewModelScope.container(State())

    class State()
    sealed interface SideEffect {

    }
}
