package id.my.okisulton.kotlincrudretrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Oki Sulton on 24/05/2021.
 */
class PostRequest (
    @field:SerializedName("note")
    var note: String? = null,
)