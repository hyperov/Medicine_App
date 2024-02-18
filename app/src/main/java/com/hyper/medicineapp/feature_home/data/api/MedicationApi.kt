package com.hyper.medicineapp.feature_home.data.api

import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.feature_home.data.model.MedicationRes
import retrofit2.http.GET

interface MedicationApi {

    @GET("12b4b2f0-3a80-4b72-8de0-9c1c9e8dd510")
    suspend fun getMedicationList(): NetworkResult<MedicationRes>
}