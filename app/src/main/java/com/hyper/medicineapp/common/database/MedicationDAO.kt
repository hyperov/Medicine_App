package com.hyper.medicineapp.common.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationDAO {

    @Query("SELECT * FROM medication")
    fun getAllMedicines(): Flow<List<MedicationModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicationModel: MedicationModel): Long
}