package com.hyper.medicineapp.common.di

import com.hyper.medicineapp.common.dispatchers.BaseDispatcherProvider
import com.hyper.medicineapp.common.dispatchers.RealDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoroutinesDispatchersModule {

    @Singleton
    @Provides
    fun getScheduler(): BaseDispatcherProvider {
        return RealDispatchers()
    }
}