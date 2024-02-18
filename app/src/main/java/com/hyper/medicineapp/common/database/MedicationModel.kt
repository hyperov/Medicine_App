package com.hyper.medicineapp.common.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "medication")
data class MedicationModel(

    @ColumnInfo(name = "name") val drugName: String?,
    @ColumnInfo(name = "dose") val dose: String?,
    @ColumnInfo(name = "strength") val strength: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}