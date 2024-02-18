package com.hyper.medicineapp.common.api

sealed interface NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>
    data class Error<out T : Any>(val code: Int, val errorMsg: String?) : NetworkResult<T>
    data class Exception<out T : Any>(val e: Throwable) : NetworkResult<T>
}

