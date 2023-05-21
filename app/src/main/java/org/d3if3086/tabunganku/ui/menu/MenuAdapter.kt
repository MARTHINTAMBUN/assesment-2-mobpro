package org.d3if3086.tabunganku.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3086.tabunganku.databinding.ItemDashboardBinding
import org.d3if3086.tabunganku.db.TabunganEntity

class MenuAdapter :
    ListAdapter<TabunganEntity, MenuAdapter.ViewHolder>(DIFF_CALLBACK) {
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
        val binding = ItemDashboardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemDashboardBinding

    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TabunganEntity){
            binding.saldo.text = item.saldo.toString()
            binding.tanggalTextView.text = "Saldo anda"
        }

    }
}