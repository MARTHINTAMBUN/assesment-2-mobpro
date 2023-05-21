package org.d3if3086.tabunganku.ui.tabung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3086.tabunganku.db.TabunganDao
import org.d3if3086.tabunganku.db.TabunganEntity

class TabungViewModel(private val db: TabunganDao) : ViewModel() {

    val dataDb = db.getLastData()

    fun tambah() = viewModelScope.launch {
        val dataTabungan = TabunganEntity(
            saldo = 0f,
            tambah = 0f,
            tarik = 0f,
            isTarik = false
        )

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataTabungan)
            }
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}