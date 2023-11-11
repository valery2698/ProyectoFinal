package utn.valeryemmanuel.proyectofinal.navegation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){
    object SignUpScreen : Screen()
    object HomeScreen : Screen()


}

object PostOfficeAppRouter{
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigate(destination:Screen){
        currentScreen.value = destination
    }
}