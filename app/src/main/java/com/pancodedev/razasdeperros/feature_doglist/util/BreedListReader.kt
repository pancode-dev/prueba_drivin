package com.pancodedev.razasdeperros.feature_doglist.util

import com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo.BreedList

object BreedListReader {
    fun getBreedListAsPairs(breedList: BreedList) : List<Pair<String, String?>> {
        var pairList = mutableListOf<Pair<String, String?>>()
        breedList.javaClass.declaredFields.forEach { field ->
            field.isAccessible = true
            val breed = field.get(breedList) as List<*>

            when(breed.size) {
                0 -> pairList.add(Pair(field.name, null))
                else -> {
                    breed.forEach { pairList.add(Pair(field.name, it.toString())) }
                }
            }
        }
        return pairList
    }
}