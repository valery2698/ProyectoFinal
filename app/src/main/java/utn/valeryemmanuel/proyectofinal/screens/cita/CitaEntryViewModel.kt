package utn.valeryemmanuel.proyectofinal.screens.cita

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import utn.valeryemmanuel.proyectofinal.data.Cita
import utn.valeryemmanuel.proyectofinal.data.CitasRepository

class CitaEntryViewModel(private val citasRepository: CitasRepository) : ViewModel() {

    var citaUiState by mutableStateOf(CitaUiState())
        private set

    fun updateUiState(citaDetails: CitaDetails) {
        citaUiState =
            CitaUiState(citaDetails = citaDetails, isEntryValid = validateInput(citaDetails))
    }

    suspend fun saveCita() {
        if (validateInput()) {
            citasRepository.insertCita(citaUiState.citaDetails.toCita())
        }
    }

    private fun validateInput(uiState: CitaDetails = citaUiState.citaDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }

}

/**
 * Represents Ui State for an Cita.
 */
data class CitaUiState(
    val citaDetails: CitaDetails = CitaDetails(),
    val isEntryValid: Boolean = false
)

data class CitaDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

fun CitaDetails.toCita(): Cita = Cita(
    id = id,
    nombre = name,
    precio = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

/*fun Cita.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}*/

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Cita.toItemUiState(isEntryValid: Boolean = false): CitaUiState = CitaUiState(
    citaDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Cita.toItemDetails(): CitaDetails = CitaDetails(
    id = id,
    name = nombre,
    price = precio.toString(),
    quantity = quantity.toString()
)