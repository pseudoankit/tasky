package pseudoankit.droid.tasky.launcher

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.core.util.extension.orFalse
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.state
import pseudoankit.droid.preferencesmanager.PreferenceRepository

class MainActivityViewModel(
    private val preferenceRepository: PreferenceRepository
) : ViewModel(),
    ContainerHost<MainActivityViewModel.State, MainActivityViewModel.SideEffect> {

    override val container: Container<State, SideEffect> = viewModelScope.container(
        initialState = State(
            isUserLoggedIn = runBlocking { preferenceRepository.isLoggedIn().orFalse }
        )
    )

    init {
        observeLoggedInStatus()
        handleNotificationPermission()
    }

    private fun observeLoggedInStatus() {
        preferenceRepository.isLoggedInFlow()
            .onEach { isLoggedIn ->
                if (!isLoggedIn && !state.isUserLoggedIn) {
                    postSideEffect {
                        SideEffect.ClearBackStackAndNavigateToLogin
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun handleNotificationPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return
        postSideEffect {
            SideEffect.LaunchNotificationPermissionRequest
        }
    }


    data class State(
        val isUserLoggedIn: Boolean = true
    )

    sealed interface SideEffect {
        object ClearBackStackAndNavigateToLogin : SideEffect
        object LaunchNotificationPermissionRequest : SideEffect
    }
}
