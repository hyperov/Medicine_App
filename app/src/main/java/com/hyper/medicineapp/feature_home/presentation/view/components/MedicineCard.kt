package com.hyper.medicineapp.feature_home.presentation.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyper.medicineapp.feature_home.presentation.state.MedicationUiModel
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationItemViewModel

@Composable
fun MedicineCard(
    medicineName: String,
    dose: String,
    strength: String,
    onNavigateToDetails: () -> Unit,
    MedicationItemViewModel: MedicationItemViewModel
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        border = BorderStroke(2.dp, MaterialTheme.colors.primary),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                onNavigateToDetails()
                MedicationItemViewModel.clickedItem =
                    MedicationUiModel(medicineName, dose, strength)
            },
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                text = "Medicine: ${medicineName.replaceFirstChar { it.uppercase() }}",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                text = "Dose: ${dose.ifEmpty { "N/A" }}",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                text = "Strength: $strength",
            )
        }
    }
}