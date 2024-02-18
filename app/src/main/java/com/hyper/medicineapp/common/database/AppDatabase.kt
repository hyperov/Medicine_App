package com.hyper.medicineapp.common.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MedicationModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDAO
}