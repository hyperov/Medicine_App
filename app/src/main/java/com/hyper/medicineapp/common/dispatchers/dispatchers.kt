package com.hyper.medicineapp.common.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

interface BaseDispatcherProvider {
    fun io(): CoroutineDispatcher
    fun ui(): CoroutineDispatcher
    fun computation(): CoroutineDispatcher
}

class RealDispatchers : BaseDispatcherProvider {
    override fun io() = Dispatchers.IO
    override fun ui() = Dispatchers.Main
    override fun computation() = Dispatchers.Default
}

@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatchers : BaseDispatcherProvider {
    override fun io() = UnconfinedTestDispatcher()
    override fun ui() = UnconfinedTestDispatcher()
    override fun computation() = UnconfinedTestDispatcher()
}