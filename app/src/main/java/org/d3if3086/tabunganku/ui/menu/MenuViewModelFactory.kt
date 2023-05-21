package org.d3if3086.tabunganku.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3086.tabunganku.db.TabunganDao
import org.d3if3086.tabunganku.ui.tabung.TabungViewModel

class MenuViewModelFactory(
    private val db: TabunganDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
            return MenuViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}