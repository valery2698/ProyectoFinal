package utn.valeryemmanuel.proyectofinal.screens.cita

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CitaDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val citaId: Int = checkNotNull(savedStateHandle[CitaDetailsDestination.itemIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val citaDetails: CitaDetails = CitaDetails()
)