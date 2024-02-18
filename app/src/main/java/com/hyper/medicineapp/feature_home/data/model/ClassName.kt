package com.hyper.medicineapp.feature_home.data.model


import com.google.gson.annotations.SerializedName

data class ClassName(
    @SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrug>,
    @SerializedName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrug>
)