package com.pancodedev.razasdeperros.feature_doglist.model.remote

import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedListResponse
import com.pancodedev.razasdeperros.feature_doglist.util.ApiData
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {

    @GET(ApiData.BREED_LIST_ENDPOINT)
    suspend fun getBreedList(): Response<BreedListResponse>

}