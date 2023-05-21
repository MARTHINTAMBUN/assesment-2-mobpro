package org.d3if3051.mobpro1.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3086.tabunganku.db.TabunganDao

class HistoriViewModel(private val db: TabunganDao) : ViewModel() {
    val data = db.getAllData()


    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}