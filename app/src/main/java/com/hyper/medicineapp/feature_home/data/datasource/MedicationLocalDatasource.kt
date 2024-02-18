package com.hyper.medicineapp.feature_home.data.datasource

import com.hyper.medicineapp.common.database.MedicationDAO
import com.hyper.medicineapp.common.database.MedicationModel
import javax.inject.Inject

class MedicationLocalDatasource @Inject constructor(private val medicationDAO: MedicationDAO) {

    fun getMedicationList() = medicationDAO.getAllMedicines()

    suspend fun insertMedication(medicationModel: MedicationModel) =
        medicationDAO.insertMedicine(medicationModel)
}