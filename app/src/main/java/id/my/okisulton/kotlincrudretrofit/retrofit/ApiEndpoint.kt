package id.my.okisulton.kotlincrudretrofit.retrofit

import id.my.okisulton.kotlincrudretrofit.model.NoteModel
import id.my.okisulton.kotlincrudretrofit.model.PostRequest
import id.my.okisulton.kotlincrudretrofit.model.PostResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Oki Sulton on 21/05/2021.
 */
interface ApiEndpoint {
    @GET("data.php")
    fun data() : Call<NoteModel>

    @POST("insert.php")
    fun createNote(@Body req: PostRequest): Call<PostResponse>
}