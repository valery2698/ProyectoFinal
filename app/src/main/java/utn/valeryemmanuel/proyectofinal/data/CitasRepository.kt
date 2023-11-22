package utn.valeryemmanuel.proyectofinal.data

import kotlinx.coroutines.flow.Flow

interface CitasRepository {

    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllCitasStream(): Flow<List<Cita>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getCitaStream(id: Int): Flow<Cita?>

    /**
     * Insert item in the data source
     */
    suspend fun insertCita(cita: Cita)

    /**
     * Delete item from the data source
     */
    suspend fun deleteCita(cita: Cita)

    /**
     * Update item in the data source
     */
    suspend fun updateCita(cita: Cita)

}