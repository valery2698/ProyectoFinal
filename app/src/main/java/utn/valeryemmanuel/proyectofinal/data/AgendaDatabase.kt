package utn.valeryemmanuel.proyectofinal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cita::class], version = 1, exportSchema = false)
abstract class AgendaDatabase : RoomDatabase() {

    abstract fun citaDao(): CitaDao

    companion object {
        @Volatile
        private var Instance: AgendaDatabase? = null

        fun getDatabase(context: Context): AgendaDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AgendaDatabase::class.java, "item_database")
                    .build().also { Instance = it }
            }
        }
    }

}


