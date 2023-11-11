package utn.valeryemmanuel.proyectofinal.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import utn.valeryemmanuel.proyectofinal.navegation.PostOfficeAppRouter
import utn.valeryemmanuel.proyectofinal.navegation.Screen
import utn.valeryemmanuel.proyectofinal.screens.HomeScreen
import utn.valeryemmanuel.proyectofinal.screens.SignUpScreen


@Composable
fun PostOfficeApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.HomeScreen ->{
                    HomeScreen()
                }
            }
        }

    }
}

@Preview
@Composable
fun DefaultPreviewPostOfficeApp(){
    PostOfficeApp()
}