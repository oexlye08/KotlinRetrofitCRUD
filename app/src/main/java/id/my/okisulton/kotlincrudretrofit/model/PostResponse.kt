package id.my.okisulton.kotlincrudretrofit.model

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("messages")
	val messages: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
