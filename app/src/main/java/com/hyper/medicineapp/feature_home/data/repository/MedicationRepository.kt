package com.hyper.medicineapp.feature_home.data.repository

import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.feature_home.data.model.MedicationRes
import kotlinx.coroutines.flow.Flow

interface MedicationRepository {

    suspend fun getMedicationList(): Flow<NetworkResult<MedicationRes>>
}