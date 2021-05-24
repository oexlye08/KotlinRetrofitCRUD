package id.my.okisulton.kotlincrudretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.my.okisulton.kotlincrudretrofit.R
import id.my.okisulton.kotlincrudretrofit.model.NoteModel
import kotlinx.android.synthetic.main.list_note.view.*

/**
 * Created by Oki Sulton on 24/05/2021.
 */
class NoteAdapter(
    val notes: ArrayList<NoteModel.DataItem>
): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_note, parent, false)
    )

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val note = notes[position]
        holder.itemView.tv_notes.text = note.catatan
    }

    override fun getItemCount() = notes.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    public fun setData(data: List<NoteModel.DataItem>){
        notes.clear()
        notes.addAll(data)
        notifyDataSetChanged()
    }
}