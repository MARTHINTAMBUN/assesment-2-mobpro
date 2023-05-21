package org.d3if3086.tabunganku.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3086.tabunganku.db.TabunganDao
import org.d3if3086.tabunganku.db.TabunganEntity

class MenuViewModel(private val db: TabunganDao) : ViewModel() {

    val data = db.getData()

    fun tambah(tambahData: Float, saldoData: Float) = viewModelScope.launch {
        val sald = saldoData + tambahData
        val dataTabungan = TabunganEntity(
            saldo = sald,
            tambah = tambahData,
            tarik = 0f,
            isTarik = false
        )

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataTabungan)
            }
        }
    }

    fun tarik(tambahData: Float, saldoData: Float) = viewModelScope.launch {
        val sald = saldoData - tambahData
        val dataTabungan = TabunganEntity(
            saldo = sald,
            tambah = 0f,
            tarik = tambahData,
            isTarik = true
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