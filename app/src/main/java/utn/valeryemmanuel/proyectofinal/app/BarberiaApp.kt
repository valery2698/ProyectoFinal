package utn.valeryemmanuel.proyectofinal.app

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import utn.valeryemmanuel.proyectofinal.R
import androidx.navigation.compose.rememberNavController
import utn.valeryemmanuel.proyectofinal.data.DataSource
import utn.valeryemmanuel.proyectofinal.screens.CitaViewModel
import utn.valeryemmanuel.proyectofinal.screens.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import utn.valeryemmanuel.proyectofinal.screens.SelectOptionScreen
import utn.valeryemmanuel.proyectofinal.screens.SignUpScreen


enum class BarberiaScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name), //Menu Principal
    Fecha(title = R.string.fecha), // Registra fecha para la cita
    Cita(title = R.string.nuevaCita), // Info para la cita
    Resumen(title = R.string.resumen) // Resumen de la cita agendada

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberiaAppBar(
    currentScreen: BarberiaScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberiaApp(
    viewModel: CitaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = BarberiaScreen.valueOf(
        backStackEntry?.destination?.route ?: BarberiaScreen.Start.name
    )

    Scaffold(
        topBar = {
            BarberiaAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = BarberiaScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BarberiaScreen.Start.name) {
                HomeScreen(
                    quantityOptions = DataSource.quantityOptions,
                    onNextButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(BarberiaScreen.Fecha.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = BarberiaScreen.Fecha.name) {
                SelectOptionScreen(
                    subtotal = uiState.price,
                    onNextButtonClicked = { navController.navigate(BarberiaScreen.Cita.name) },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = uiState.pickupOptions,
                    onSelectionChanged = { viewModel.setDate(it) },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = BarberiaScreen.Cita.name) {
                val context = LocalContext.current
                SelectOptionScreen(
                    subtotal = uiState.price,
                    onNextButtonClicked = { navController.navigate(BarberiaScreen.Resumen.name) },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = DataSource.servicio.map { id -> context.resources.getString(id) },
                    onSelectionChanged = { viewModel.setFlavor(it) },
                    modifier = Modifier.fillMaxHeight()
                )
            }

        }
    }

}

private fun cancelOrderAndNavigateToStart(
    viewModel: CitaViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(BarberiaScreen.Start.name, inclusive = false)
}

