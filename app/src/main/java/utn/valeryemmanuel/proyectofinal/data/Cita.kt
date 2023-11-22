package utn.valeryemmanuel.proyectofinal.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "citas")
data class Cita(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val precio: Double,
    val quantity: Int
)

