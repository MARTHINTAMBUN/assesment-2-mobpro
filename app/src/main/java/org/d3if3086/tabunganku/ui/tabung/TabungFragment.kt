package org.d3if3086.tabunganku.ui.tabung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3086.tabunganku.databinding.FragmentDashboardBinding
import org.d3if3086.tabunganku.databinding.FragmentHistoriBinding
import org.d3if3086.tabunganku.databinding.FragmentTabungBinding
import org.d3if3086.tabunganku.db.TabunganDb
import org.d3if3086.tabunganku.ui.home.HomeAdapter
import org.d3if3086.tabunganku.ui.menu.MenuViewModel

class TabungFragment : Fragment() {

    private var _binding: FragmentTabungBinding? = null
    private val viewModel: TabungViewModel by lazy {
        val db = TabunganDb.getInstance(requireContext())
        val factory = TabungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[TabungViewModel::class.java]
    }

    private lateinit var binding: FragmentTabungBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabungBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }

    private lateinit var myAdapter: TabungAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tabung.setOnClickListener { viewModel.tambah() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}