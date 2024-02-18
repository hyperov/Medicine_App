package com.hyper.medicineapp.feature_home.data.di

import com.hyper.medicineapp.feature_home.data.datasource.MedicationLocalDatasource
import com.hyper.medicineapp.feature_home.data.datasource.MedicationRemoteDatasource
import com.hyper.medicineapp.feature_home.data.repository.MedicationRepository
import com.hyper.medicineapp.feature_home.data.repository.MedicationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MedicationModule {

    @Provides
    fun provideMedicationRepository(
        localMedicationDataSource: MedicationLocalDatasource,
        RemoteMedicationDataSource: MedicationRemoteDatasource
    ): MedicationRepository {
        return MedicationRepositoryImpl(RemoteMedicationDataSource, localMedicationDataSource)
    }
}