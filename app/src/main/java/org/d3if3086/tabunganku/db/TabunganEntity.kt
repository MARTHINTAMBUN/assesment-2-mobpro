package org.d3if3086.tabunganku.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabungan")
data class TabunganEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var saldo: Float,
    var tambah: Float,
    var tarik: Float,
    var isTarik: Boolean
)