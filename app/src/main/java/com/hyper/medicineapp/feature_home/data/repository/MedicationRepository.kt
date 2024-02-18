package com.hyper.medicineapp.feature_home.data.repository

import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.feature_home.data.model.MedicationRes

interface MedicationRepository {

    suspend fun getMedicationList(): NetworkResult<MedicationRes>
}