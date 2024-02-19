package com.hyper.medicineapp.feature_home.presentation.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hyper.medicineapp.feature_home.presentation.state.MedicationUiModel
import com.hyper.medicineapp.feature_home.presentation.view.components.MedicineCard
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationItemViewModel

@Composable
fun MedicationListContent(
    medicationList: List<MedicationUiModel>,
    isLoading: Boolean,
    error: String,
    paddingValues: PaddingValues,
    onNavigateToDetails: () -> Unit,
    medicationItemViewModel: MedicationItemViewModel
) {
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .background(color = Color.White),
                strokeWidth = 5.dp
            )
            Text(text = "Loading...", modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    } else if (error.isNotEmpty()) {
        Text(text = error)
    } else {
        LazyColumn(
            content = {
                items(medicationList.size) {
                    MedicineCard(
                        medicineName = medicationList[it].drugName,
                        dose = medicationList[it].dose,
                        strength = medicationList[it].strength,
                        onNavigateToDetails = onNavigateToDetails,
                        medicationItemViewModel = medicationItemViewModel
                    )
                }
            },
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        )
    }
}