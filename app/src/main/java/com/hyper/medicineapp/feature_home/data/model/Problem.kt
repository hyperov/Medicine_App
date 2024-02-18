package com.hyper.medicineapp.feature_home.data.model


import com.google.gson.annotations.SerializedName

data class Problem(
    @SerializedName("Asthma")
    val asthma: List<Asthma>,
    @SerializedName("Diabetes")
    val diabetes: List<Diabete>
)