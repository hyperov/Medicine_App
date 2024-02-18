package com.hyper.medicineapp.common.api.customcalladapter

import com.hyper.medicineapp.common.api.NetworkResult
import retrofit2.HttpException
import retrofit2.Response

fun <T : Any> handleApi(
    execute: () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(code = response.code(), errorMsg = response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(code = e.code(), errorMsg = e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}