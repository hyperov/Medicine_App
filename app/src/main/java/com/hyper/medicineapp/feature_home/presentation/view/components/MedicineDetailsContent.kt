package com.hyper.medicineapp.feature_home.presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hyper.medicineapp.R

@Composable
fun MedicineItemDetailsContent(
    medicineName: String = "Paracetamol",
    dose: String = "500mg",
    strength: String = "10mg",
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MedicineDetailItem(
                stringResource(R.string.medicine_label),
                medicineName.ifEmpty { "N/A" },
                Color(0xFF90CAF9)
            )
            Spacer(modifier = Modifier.height(16.dp))
            MedicineDetailItem(stringResource(R.string.dose), dose.ifEmpty { "N/A" }, Color(0xFFF48FB1))
            Spacer(modifier = Modifier.height(16.dp))
            MedicineDetailItem(stringResource(R.string.strength), strength.ifEmpty { "N/A" }, Color(0xFFB2DFDB))
        }
    }
}