package org.d3if3086.tabunganku.ui.tabung

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3086.tabunganku.databinding.FragmentHomeBinding
import org.d3if3086.tabunganku.databinding.FragmentTabungBinding
import org.d3if3086.tabunganku.db.TabunganEntity
import org.d3if3086.tabunganku.ui.home.HomeAdapter
import java.text.SimpleDateFormat
import java.util.*

class TabungAdapter :
    ListAdapter<TabunganEntity, TabungAdapter.ViewHolder>(DIFF_CALLBACK) {
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
        val binding = FragmentTabungBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: FragmentTabungBinding

    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: TabunganEntity){
            binding.text1.text = item.saldo.toString()
        }


    }
}