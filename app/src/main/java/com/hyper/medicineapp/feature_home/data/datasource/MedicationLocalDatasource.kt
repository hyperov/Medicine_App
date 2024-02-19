package com.hyper.medicineapp.feature_home.data.datasource

import com.hyper.medicineapp.common.database.MedicationDAO
import com.hyper.medicineapp.common.database.MedicationModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MedicationLocalDatasource @Inject constructor(private val medicationDAO: MedicationDAO) {

    fun getMedicationList() = medicationDAO.getAllMedicines()

    suspend fun insertMedication(medicationModel: MedicationModel) =
        flow { emit(medicationDAO.insertMedicine(medicationModel)) }
}