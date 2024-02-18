package com.hyper.medicineapp.feature_home.presentation.view.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.hyper.medicineapp.common.components.TopBar
import com.hyper.medicineapp.feature_home.presentation.view.components.MedicineItemDetailsContent
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationItemViewModel

@Composable
fun MedicineDetailsScreen(
    medicineName: String = "Paracetamol",
    dose: String = "500mg",
    strength: String = "10mg",
    onNavigateBackToHome: () -> Unit,
    medicationItemViewModel: MedicationItemViewModel
) {
    val clickedItem = medicationItemViewModel.clickedItem

    Scaffold(
        topBar = {
            TopBar(
                onNavigateBack = { onNavigateBackToHome() },
                title = "Medicine Details: ${clickedItem.drugName}"
            )
        },
    ) {

        MedicineItemDetailsContent(
            medicineName = clickedItem.drugName,
            dose = clickedItem.dose,
            strength = clickedItem.strength
        )
    }
}


@Preview
@Composable
fun showDetails() {
    MedicineDetailsScreen(
        medicineName = "Paracetamol",
        dose = "500mg",
        strength = "10mg",
        onNavigateBackToHome = {},
        medicationItemViewModel = hiltViewModel()
    )
}