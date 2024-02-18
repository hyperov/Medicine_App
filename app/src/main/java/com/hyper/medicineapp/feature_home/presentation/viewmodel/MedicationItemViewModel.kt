package com.hyper.medicineapp.feature_home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hyper.medicineapp.feature_home.presentation.state.MedicationUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MedicationItemViewModel @Inject constructor() : ViewModel() {

    var clickedItem by mutableStateOf(
        MedicationUiModel(
            drugName = "",
            dose = "",
            strength = ""
        )
    )


}