package com.pancodedev.razasdeperros.feature_doglist.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancodedev.razasdeperros.feature_doglist.model.DogRepository
import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import kotlin.coroutines.coroutineContext

class MainViewModel: ViewModel() {
    private val repository = DogRepository()

    fun getBreedList() = repository.getBreedList()
    fun getDogList() =repository.getDogList()

    fun fetchBreedListFromServer(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchBreedListFromServer()
        }
    }

    fun fetchDogImagesFromServer(breedList: List<Pair<String, String?>>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchDogImagesFromServer(breedList)
        }
    }
}