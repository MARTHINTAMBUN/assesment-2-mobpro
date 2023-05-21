package org.d3if3051.mobpro1.ui.histori


import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3086.tabunganku.R
import org.d3if3086.tabunganku.databinding.ItemHistoriBinding
import org.d3if3086.tabunganku.db.TabunganEntity
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter : ListAdapter<TabunganEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<TabunganEntity>() {
                override fun areItemsTheSame(
                    oldData: TabunganEntity, newData: TabunganEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: TabunganEntity, newData: TabunganEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )
        fun bind(item: TabunganEntity) = with(binding) {
            val colorRes = if(item.isTarik) {
                R.color.tarik
            } else {
                R.color.tabung
            }
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(ContextCompat.getColor(root.context, colorRes))
            tanggalTextView.text = "Tanggal: " + dateFormatter.format(Date(item.tanggal))
            tambahTextView.text = (if (item.isTarik){
                "nominal penarikan: " + item.tarik
            } else {
                "nominal penambahan: " + item.tambah
            }).toString()

            saldoTextView.text = "Saldo anda: " + item.saldo.toString()
        }
    }

}
