package utn.valeryemmanuel.proyectofinal

import android.app.Application
import utn.valeryemmanuel.proyectofinal.data.AppContainer
import utn.valeryemmanuel.proyectofinal.data.AppDataContainer

class AgendaApplication: Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}