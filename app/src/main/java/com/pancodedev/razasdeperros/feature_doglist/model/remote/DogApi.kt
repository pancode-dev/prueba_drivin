package com.pancodedev.razasdeperros.feature_doglist.model.remote

import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedListResponse
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.DogImageResponse
import com.pancodedev.razasdeperros.feature_doglist.util.ApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET(ApiData.BREED_LIST_ENDPOINT)
    suspend fun getBreedList(): Response<BreedListResponse>

    @GET(ApiData.RANDOM_IMAGE_ENDPOINT)
    suspend fun getRandomImage(@Path(ApiData.BREED_PATH, encoded = true) breed: String): Response<DogImageResponse>
}