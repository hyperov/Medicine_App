package com.hyper.medicineapp.feature_home.data.model


import com.google.gson.annotations.SerializedName

data class MedicationsClasse(
    @SerializedName("className")
    val className: List<ClassName>,
    @SerializedName("className2")
    val className2: List<ClassName>
)