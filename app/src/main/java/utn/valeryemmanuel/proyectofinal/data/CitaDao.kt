package utn.valeryemmanuel.proyectofinal.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface CitaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cita: Cita)

    @Update
    suspend fun update(cita: Cita)

    @Delete
    suspend fun delete(cita: Cita)

    @Query("SELECT * from citas WHERE id = :id")
    fun getCita(id: Int): Flow<Cita>

    @Query("SELECT * from citas ORDER BY nombre ASC")
    fun getAllCitas(): Flow<List<Cita>>


}