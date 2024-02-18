package com.hyper.medicineapp.feature_home.presentation.state

class MedicationListState(
    val medicationList: List<MedicationUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)