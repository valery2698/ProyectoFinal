package utn.valeryemmanuel.proyectofinal.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaDetailsDestination
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaDetailsScreen
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaEditDestination
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaEditScreen
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaEntryDestination
import utn.valeryemmanuel.proyectofinal.screens.cita.CitaEntryScreen
import utn.valeryemmanuel.proyectofinal.screens.home.HomeDestination
import utn.valeryemmanuel.proyectofinal.screens.home.HomeScreen

@Composable
fun AgendaNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController, startDestination = HomeDestination.route, modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(CitaEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${CitaDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = CitaEntryDestination.route) {
            CitaEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = CitaDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(CitaDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            CitaDetailsScreen(
                navigateToEditItem =
                {
                    navController.navigate("${CitaEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = CitaEditDestination.routeWithArgs,
            arguments = listOf(navArgument(CitaEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            CitaEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
    }
}