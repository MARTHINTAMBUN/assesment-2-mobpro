package org.d3if3086.tabunganku.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3086.tabunganku.R
import org.d3if3086.tabunganku.databinding.FragmentDashboardBinding
import org.d3if3086.tabunganku.databinding.FragmentHomeBinding
import org.d3if3086.tabunganku.databinding.ItemDashboardBinding
import org.d3if3086.tabunganku.db.TabunganDb
import org.d3if3086.tabunganku.ui.home.HomeAdapter
import org.d3if3086.tabunganku.ui.home.HomeViewModel
import org.d3if3086.tabunganku.ui.home.HomeViewModelFactory

class MenuFragment : Fragment() {

    private val viewModel: MenuViewModel by lazy {
        val db = TabunganDb.getInstance(requireContext())
        val factory = MenuViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[MenuViewModel::class.java]
    }
    private var _binding: FragmentDashboardBinding? = null
    private lateinit var myAdapter: MenuAdapter

    private lateinit var binding: FragmentDashboardBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(layoutInflater,
            container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myAdapter = MenuAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        viewModel.data.observe(viewLifecycleOwner, {
            myAdapter.submitList(it)
        })
        binding.tambah.setOnClickListener {
            tambah()
        }
        binding.tarik.setOnClickListener {
            tarik()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun tambah()
    {
        val dataTambah = binding.tambahEditText.text.toString()
        val saldoData = binding.tambahEditText2.text.toString()
        viewModel.tambah(
            dataTambah.toFloat(),
            saldoData.toFloat()
        )
    }

    fun tarik()
    {
        val dataTambah = binding.tambahEditText.text.toString()
        val saldoData = binding.tambahEditText2.text.toString()
        viewModel.tarik(
            dataTambah.toFloat(),
            saldoData.toFloat()
        )
    }
}