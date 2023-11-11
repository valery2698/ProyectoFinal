package utn.valeryemmanuel.proyectofinal.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import utn.valeryemmanuel.proyectofinal.R
import utn.valeryemmanuel.proyectofinal.components.ButtonComponent
import utn.valeryemmanuel.proyectofinal.components.HeadingTextComponent
import utn.valeryemmanuel.proyectofinal.components.MyPasswordFieldComponent
import utn.valeryemmanuel.proyectofinal.components.MyTextFieldComponent
import utn.valeryemmanuel.proyectofinal.components.NormalTextComponent
import utn.valeryemmanuel.proyectofinal.navegation.PostOfficeAppRouter
import utn.valeryemmanuel.proyectofinal.navegation.Screen

@Composable
fun SignUpScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()){
            NormalTextComponent(value = stringResource(id = R.string.saludo))
            HeadingTextComponent(value = stringResource(id = R.string.nuevaCuenta))

            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(labelValue = stringResource(id = R.string.name))
            MyTextFieldComponent(labelValue = stringResource(id = R.string.lastName))
            MyTextFieldComponent(labelValue = stringResource(id = R.string.email))
            MyPasswordFieldComponent(labelValue = stringResource(id = R.string.password))

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value="Register",
                onClick = {
                    PostOfficeAppRouter.navigate(Screen.HomeScreen)
                })

        }


    }
}

@Preview
@Composable
fun DefaultPreviewSignUpScreen(){
    SignUpScreen()
}
