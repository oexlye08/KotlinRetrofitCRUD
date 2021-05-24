package id.my.okisulton.kotlincrudretrofit.model

data class NoteModel(
	val data: ArrayList<DataItem?>? = null
){
	data class DataItem(
		val catatan: String? = null,
		val id: String? = null
	)
}



