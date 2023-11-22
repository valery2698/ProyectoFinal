package utn.valeryemmanuel.proyectofinal.screens

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import utn.valeryemmanuel.proyectofinal.AgendaApplication
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaDetailsViewModel
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaEditViewModel
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaEntryViewModel
import utn.valeryemmanuel.proyectofinal.screens.home.HomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            CitaEditViewModel(
                this.createSavedStateHandle()
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            CitaEntryViewModel(inventoryApplication().container.citasRepository)
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            CitaDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(inventoryApplication().container.citasRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): AgendaApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AgendaApplication)
