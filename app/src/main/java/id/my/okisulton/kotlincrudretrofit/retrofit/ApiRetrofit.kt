package id.my.okisulton.kotlincrudretrofit.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Oki Sulton on 21/05/2021.
 */
class ApiRetrofit {

    val BASE_URL = "http://192.168.10.106/kotlin_crud/"
    val endpoint: ApiEndpoint
        get() {
            //add interceptor (optional)
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val gson = GsonBuilder()
                .setLenient()
                .create()

            //add client
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            //add retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                    //add client fot interceptor
                .client( client )
                    //end client
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiEndpoint::class.java)
        }
}