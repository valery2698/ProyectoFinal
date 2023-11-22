package utn.valeryemmanuel.proyectofinal.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import utn.valeryemmanuel.proyectofinal.data.Cita
import utn.valeryemmanuel.proyectofinal.data.CitasRepository

class HomeViewModel(citasRepository: CitasRepository) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        citasRepository.getAllCitasStream().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 10_000L
    }
}

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val itemList: List<Cita> = listOf())