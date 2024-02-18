package com.hyper.medicineapp.common.di

import com.google.gson.Gson
import com.hyper.medicineapp.BuildConfig
import com.hyper.medicineapp.feature_home.data.api.MedicationApi
import com.hyper.medicineapp.common.api.customcalladapter.NetworkResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object MedicationNetworkModule {

    @Provides
    fun getRetrofitInstance(): MedicationApi {

        var client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)
        }

        client = client
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            .build()
        return retrofit.create()
    }

}