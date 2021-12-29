package com.pancodedev.razasdeperros.feature_doglist.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pancodedev.razasdeperros.feature_doglist.model.remote.RetrofitInstance
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedList
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedListResponse
import com.pancodedev.razasdeperros.feature_doglist.util.BreedListReader
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class DogRepository {
    private val tag = this::class.simpleName

    private val breedList = MutableLiveData<List<Pair<String, String?>>>(mutableListOf())

    fun getBreedList() = breedList

    suspend fun fetchBreedListFromServer() {

        val response: Response<BreedListResponse> = try {
            RetrofitInstance.api.getBreedList()
        } catch(e: IOException) {
            Log.e(tag, "IOException, you might not have internet connection")
            return
        } catch (e: HttpException) {
            Log.e(tag, "HttpException, unexpected response")
            return
        }

        if(response.isSuccessful && response.body() != null) {
            breedList.postValue(BreedListReader.getBreedListAsPairs(response.body()!!.breedList!!))
        } else {
            Log.e(tag, "Response not successful")
        }
    }

}