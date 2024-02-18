package com.hyper.medicineapp.feature_home.presentation.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hyper.medicineapp.R
import com.hyper.medicineapp.common.components.TopBar
import com.hyper.medicineapp.common.util.getGreetingsBasedOnTime
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationItemViewModel
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationListViewModel
import com.hyper.medicineapp.feature_login.presentation.viewmodel.LoginViewModel

@Composable
fun MedicineListScreen(
    medicationListViewModel: MedicationListViewModel = hiltViewModel(),
    loginViewModel: LoginViewModel = hiltViewModel(),
    onNavigateToDetails: () -> Unit,
    onNavigateBackToLogin: () -> Unit,
    MedicationItemViewModel: MedicationItemViewModel
) {

    val state = medicationListViewModel.uiState.collectAsState()

    LaunchedEffect(key1 = medicationListViewModel.uiState) {
        medicationListViewModel.getMedicationList()
    }

    Scaffold(
        topBar = {
            TopBar(
                onNavigateBack = onNavigateBackToLogin,
                title = stringResource(R.string.medicine_list_screen_title)
            )

        },
    ) { paddingValues ->
        Column {
            Text(
                text = "${getGreetingsBasedOnTime()} ${loginViewModel.userName}!",
                style = MaterialTheme.typography.h5,
                color = Color.Magenta,
                modifier = Modifier
                    .padding(16.dp)
            )
            MedicationListContent(
                medicationList = state.value.medicationList,
                isLoading = state.value.isLoading,
                error = state.value.error,
                paddingValues = paddingValues,
                onNavigateToDetails = onNavigateToDetails,
                MedicationItemViewModel = MedicationItemViewModel
            )
        }
    }

}


