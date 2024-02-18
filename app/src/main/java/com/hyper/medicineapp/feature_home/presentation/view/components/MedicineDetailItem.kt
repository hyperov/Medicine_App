package com.hyper.medicineapp.feature_home.presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Android
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MedicineDetailItem(title: String, value: String, color: Color) {
    Surface(shape = RoundedCornerShape(16.dp)) {

        Row(
            modifier = Modifier
                .background(color = color)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Rounded.Android, contentDescription = null)
            Spacer(modifier = Modifier.width(32.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
            }
        }

    }
}
