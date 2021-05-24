package id.my.okisulton.kotlincrudretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import id.my.okisulton.kotlincrudretrofit.R
import id.my.okisulton.kotlincrudretrofit.model.NoteModel
import id.my.okisulton.kotlincrudretrofit.model.PostRequest
import id.my.okisulton.kotlincrudretrofit.model.PostResponse
import id.my.okisulton.kotlincrudretrofit.retrofit.ApiRetrofit
import kotlinx.android.synthetic.main.activity_addnote.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddnoteActivity : AppCompatActivity() {

    private val api by lazy {
        ApiRetrofit().endpoint
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)

        setupListener()
    }

    private fun setupListener() {
        btn_save.setOnClickListener {
            if (edit_notes.text.toString().isNotEmpty()){
                postNote()
            }

        }
    }

    private fun postNote() {
        var noteRequest = PostRequest()
        noteRequest.note = edit_notes.text.toString()
        api.createNote(noteRequest).enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(this@AddnoteActivity, response.body()!!.messages, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Toast.makeText(this@AddnoteActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}