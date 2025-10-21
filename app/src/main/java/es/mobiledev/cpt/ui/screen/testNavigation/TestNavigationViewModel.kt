package es.mobiledev.cpt.ui.screen.testNavigation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestNavigationViewModel
    @Inject
    constructor() : BaseViewModel<TestNavigationUiState>() {
        override val uiState: MutableStateFlow<UiState<TestNavigationUiState>> =
            MutableStateFlow(value = UiState(data = TestNavigationUiState()))

        init {
            testStateChanges()
        }

        fun testStateChanges() {
            viewModelScope.launch {
                delay(timeMillis = 1500)
                uiState.updateState {
                    it.copy(title = "Wait...")
                }
                delay(timeMillis = 1500)
                uiState.loadingState()
                delay(timeMillis = 1500)
                uiState.successState {
                    it.copy(title = "The navigation works perfectly.")
                }
            }
        }
    }
