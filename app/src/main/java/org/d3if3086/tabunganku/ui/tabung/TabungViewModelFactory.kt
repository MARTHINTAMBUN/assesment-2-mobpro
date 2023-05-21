package org.d3if3086.tabunganku.ui.tabung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3086.tabunganku.db.TabunganDao

class TabungViewModelFactory(
    private val db: TabunganDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TabungViewModel::class.java)) {
            return TabungViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}