package org.d3if3086.tabunganku.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TabunganDao {
    @Insert
    fun insert(tabungan: TabunganEntity)
    @Query("SELECT * FROM tabungan ORDER BY id DESC")
    fun getAllData(): LiveData<List<TabunganEntity>>
    @Query("SELECT * FROM tabungan ORDER BY id DESC LIMIT 1")
    fun getData(): LiveData<List<TabunganEntity>>
    @Query("SELECT saldo FROM tabungan ORDER BY id DESC LIMIT 1")
    fun getLastData(): Float
    @Query("DELETE FROM tabungan")
    fun clearData()
}