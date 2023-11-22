package utn.valeryemmanuel.proyectofinal.screens.cita

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CitaEditViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    var citaUiState by mutableStateOf(CitaUiState())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[CitaEditDestination.itemIdArg])

    private fun validateInput(uiState: CitaDetails = citaUiState.citaDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}