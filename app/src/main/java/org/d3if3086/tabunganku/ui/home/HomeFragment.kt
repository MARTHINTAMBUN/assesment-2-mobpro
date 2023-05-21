package org.d3if3086.tabunganku.ui.home

import android.content.Intent
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
import org.d3if3086.tabunganku.databinding.FragmentHomeBinding
import org.d3if3086.tabunganku.db.TabunganDb

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        val db = TabunganDb.getInstance(requireContext())
        val factory = HomeViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HomeViewModel::class.java]
    }
    private var _binding: FragmentHomeBinding? = null
    private lateinit var myAdapter: HomeAdapter

    private lateinit var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myAdapter = HomeAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        viewModel.data.observe(viewLifecycleOwner, {
            binding.emptyView.visibility = if (it.isEmpty())
                View.VISIBLE else View.GONE
            binding.button.visibility = if(it.isEmpty())
                View.VISIBLE else View.GONE
            binding.button2.visibility = if(it.isEmpty())
                View.GONE else View.VISIBLE
            binding.button.setOnClickListener { viewModel.inputData() }
            myAdapter.submitList(it)
        })
        binding.button2.setOnClickListener { findNavController().navigate(
            R.id.action_navigation_home_to_navigation_notifications) }
        binding.button3.setOnClickListener { shareData() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun shareData() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}