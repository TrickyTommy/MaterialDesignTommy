package com.example.mymaterialdesign.services

import retrofit2.Call
import retrofit2.http.GET
import com.example.mymaterialdesign.model.ProductModel


interface ProductServices {

    @GET("products")
    fun getAllProduct(): Call<MutableList<ProductModel>>
}