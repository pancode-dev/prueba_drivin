package com.pancodedev.razasdeperros.feature_doglist.model.remote.pojo

import com.google.gson.annotations.SerializedName

data class DogImageResponse(

	@field:SerializedName("message")
	val imageLink: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
