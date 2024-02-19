package com.hyper.medicineapp.feature_home.data.repository

import android.util.Log
import com.hyper.medicineapp.common.api.NetworkResult
import com.hyper.medicineapp.common.database.MedicationModel
import com.hyper.medicineapp.feature_home.data.datasource.MedicationLocalDatasource
import com.hyper.medicineapp.feature_home.data.datasource.MedicationRemoteDatasource
import com.hyper.medicineapp.feature_home.data.model.MedicationRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MedicationRepositoryImpl @Inject constructor(
    private val medicationRemoteDatasource: MedicationRemoteDatasource,
    private val medicationLocalDatasource: MedicationLocalDatasource
) : MedicationRepository {

    override suspend fun getMedicationList(): Flow<NetworkResult<MedicationRes>> {

        return medicationRemoteDatasource.getMedicationList().map {
            if (it is NetworkResult.Success) {

                val medicationsClasses =
                    it.data.problems[0].diabetes[0].medications[0].medicationsClasses[0]
                val classNames = medicationsClasses.className + medicationsClasses.className2
                val drugList = classNames.flatMap { it.associatedDrug + it.associatedDrug2 }

                drugList.forEach { drug ->
                    medicationLocalDatasource.insertMedication(
                        MedicationModel(
                            drug.name, drug.dose, drug.strength
                        )
                    ).collectLatest {
                        Log.d("insert", "Medication inserted")
                    }
                }
            }
            it
        }
    }

}
