package utn.valeryemmanuel.proyectofinal.screens.cita

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import utn.valeryemmanuel.proyectofinal.R
import utn.valeryemmanuel.proyectofinal.app.AgendaTopAppBar
import utn.valeryemmanuel.proyectofinal.navegation.NavigationDestination
import utn.valeryemmanuel.proyectofinal.screens.AppViewModelProvider

object CitaEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = R.string.edit_item_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitaEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CitaEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Scaffold(
        topBar = {
            AgendaTopAppBar(
                title = stringResource(CitaEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        CitaEntryBody(
            itemUiState = viewModel.citaUiState,
            onItemValueChange = { },
            onSaveClick = { },
            modifier = Modifier.padding(innerPadding)
        )
    }
}