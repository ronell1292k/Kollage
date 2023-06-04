package ronell.picsum.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ronell.picsum.network.PicsumApi
import java.io.IOException


sealed interface KollageUiState {
    data class Success(val photos: String) : KollageUiState
    object Error : KollageUiState
    object Loading : KollageUiState
}
class KollageViewModel: ViewModel() {

    var kollageUiState: KollageUiState by mutableStateOf(KollageUiState.Loading)
        private set

    init {
        getPicsumPhotos()
    }


    private fun getPicsumPhotos() {
        viewModelScope.launch {
            kollageUiState = try {
                val listResult = PicsumApi.retrofitService.getPics()
                KollageUiState.Success(
                    "Great success! ${listResult.size} pics released"
                )
            } catch (e: IOException) {
                KollageUiState.Error
            }
        }
    }

}