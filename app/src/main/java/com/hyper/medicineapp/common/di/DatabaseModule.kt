package com.hyper.medicineapp.common.di

import android.content.Context
import androidx.room.Room
import com.hyper.medicineapp.common.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    fun getDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-medication"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun getMedicationDao(database: AppDatabase) = database.medicationDao()
}