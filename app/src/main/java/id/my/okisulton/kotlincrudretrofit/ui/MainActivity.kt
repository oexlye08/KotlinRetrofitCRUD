package id.my.okisulton.kotlincrudretrofit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import id.my.okisulton.kotlincrudretrofit.R
import id.my.okisulton.kotlincrudretrofit.adapter.NoteAdapter
import id.my.okisulton.kotlincrudretrofit.model.NoteModel
import id.my.okisulton.kotlincrudretrofit.retrofit.ApiRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy {
        ApiRetrofit().endpoint
    }

    private lateinit var noteadapter: NoteAdapter
    private lateinit var listnote: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRv()
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun setupListener() {
        fab_add.setOnClickListener {
            startActivity(Intent(this, AddnoteActivity::class.java))
        }
    }

    private fun setupRv() {
//        listnote = rv_notes
//        noteadapter.notifyDataSetChanged()
//        listnote.adapter = noteadapter
        noteadapter = NoteAdapter(arrayListOf())
        rv_notes.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = noteadapter
        }

    }

    private fun getNote() {
        api.data().enqueue(object : Callback<NoteModel>{
            override fun onResponse(call: Call<NoteModel>, response: Response<NoteModel>) {
                if (response.isSuccessful){
                    shotNote(response.body()!!)
                }
                Log.d("MainActivity", response.toString())
            }

            override fun onFailure(call: Call<NoteModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "kosong", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun shotNote(data : NoteModel) {
        val data = data.data
        noteadapter.setData(data as List<NoteModel.DataItem>)
    }
}