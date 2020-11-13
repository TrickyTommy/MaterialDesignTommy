package com.example.mymaterialdesign.clients

import com.example.mymaterialdesign.services.ProductServices
import com.example.mymaterialdesign.util.UtilProduct
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ProductClient {
    val service: ProductServices by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()

        retrofit.create(ProductServices::class.java)
    }
}