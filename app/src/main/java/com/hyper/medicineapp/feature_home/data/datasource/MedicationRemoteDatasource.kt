package com.hyper.medicineapp.feature_home.data.datasource

import com.hyper.medicineapp.feature_home.data.api.MedicationApi
import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.feature_home.data.model.MedicationRes
import javax.inject.Inject

class MedicationRemoteDatasource @Inject constructor(val api: MedicationApi) {

    suspend fun getMedicationList(): NetworkResult<MedicationRes> {
        return api.getMedicationList()
    }
}