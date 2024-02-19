package com.hyper.medicineapp.feature_home.data.datasource

import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.feature_home.data.api.MedicationApi
import com.hyper.medicineapp.feature_home.data.model.MedicationRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MedicationRemoteDatasource @Inject constructor(val api: MedicationApi) {

    suspend fun getMedicationList(): Flow<NetworkResult<MedicationRes>> {
        return flow { emit(api.getMedicationList()) }
    }
}