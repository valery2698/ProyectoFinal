package utn.valeryemmanuel.proyectofinal.data

import android.content.Context

interface AppContainer {
    val citasRepository: CitasRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val citasRepository: CitasRepository by lazy {
        OfflineCitasRepository(AgendaDatabase.getDatabase(context).citaDao())
    }
}