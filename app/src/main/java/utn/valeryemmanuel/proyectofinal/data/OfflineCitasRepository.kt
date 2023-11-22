package utn.valeryemmanuel.proyectofinal.data

import kotlinx.coroutines.flow.Flow

class OfflineCitasRepository(private val citaDao: CitaDao) : CitasRepository {

    override fun getAllCitasStream(): Flow<List<Cita>> = citaDao.getAllCitas()

    override fun getCitaStream(id: Int): Flow<Cita?> = citaDao.getCita(id)

    override suspend fun insertCita(cita: Cita) = citaDao.insert(cita)

    override suspend fun deleteCita(cita: Cita) = citaDao.delete(cita)

    override suspend fun updateCita(cita: Cita) = citaDao.update(cita)


}