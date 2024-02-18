package com.hyper.medicineapp.common.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun TopBar(onNavigateBack: () -> Unit, title: String) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentColor = MaterialTheme.colors.onPrimary,
        title = {
            Text(title)
        },
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}