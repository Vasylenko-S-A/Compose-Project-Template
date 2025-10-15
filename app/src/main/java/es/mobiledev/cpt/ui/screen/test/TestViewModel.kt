package es.mobiledev.cpt.ui.screen.test

import androidx.lifecycle.viewModelScope
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TestViewModel : BaseViewModel<TestUiState>() {
    override val uiState: MutableStateFlow<UiState<TestUiState>> = MutableStateFlow(UiState(TestUiState()))

    init {
        testStateChanges()
    }

    fun testStateChanges() {
        viewModelScope.launch {
            delay(1500)
            uiState.updateState {
                it.copy("Wait...")
            }
            delay(1500)
            uiState.loadingState()
            delay(1500)
            uiState.successState {
                it.copy("Hello Android!")
            }
        }
    }
}
