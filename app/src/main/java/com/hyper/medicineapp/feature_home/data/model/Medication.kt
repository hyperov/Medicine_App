package com.hyper.medicineapp.feature_home.data.model


import com.google.gson.annotations.SerializedName

data class Medication(
    @SerializedName("medicationsClasses")
    val medicationsClasses: List<MedicationsClasses>
)