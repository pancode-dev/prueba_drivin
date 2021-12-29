package com.pancodedev.razasdeperros.feature_doglist.model.remote

import com.pancodedev.razasdeperros.feature_doglist.util.ApiData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: DogApi by lazy {
        Retrofit.Builder()
            .baseUrl(ApiData.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApi::class.java)
    }
}