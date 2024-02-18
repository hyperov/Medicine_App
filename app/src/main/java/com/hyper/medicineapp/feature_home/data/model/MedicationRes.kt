package com.hyper.medicineapp.feature_home.data.model


import com.google.gson.annotations.SerializedName
import com.hyper.medicineapp.feature_home.presentation.state.MedicationUiModel

data class MedicationRes(
    @SerializedName("problems")
    val problems: List<Problem>
)

fun MedicationRes.toMedicationUi(): List<MedicationUiModel> {

    val medicationsClasse = problems[0].diabetes[0].medications[0].medicationsClasses[0]
    val classNames = medicationsClasse.className + medicationsClasse.className2
    val drugList = classNames.flatMap { it.associatedDrug + it.associatedDrug2 }

    return drugList.map { drug ->
        MedicationUiModel(
            drug.name,
            drug.dose,
            drug.strength
        )
    }
}