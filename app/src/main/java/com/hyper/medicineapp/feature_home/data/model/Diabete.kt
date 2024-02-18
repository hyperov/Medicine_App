package com.hyper.medicineapp.feature_home.data.model


import com.google.gson.annotations.SerializedName

data class Diabete(
    @SerializedName("labs")
    val labs: List<Lab>,
    @SerializedName("medications")
    val medications: List<Medication>
)