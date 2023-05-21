package org.d3if3086.tabunganku.ui.tarik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3086.tabunganku.databinding.FragmentTabungBinding
import org.d3if3086.tabunganku.databinding.FragmentTarikBinding
import org.d3if3086.tabunganku.ui.tabung.TabungViewModel

class TarikFragment : Fragment() {

    private var _binding: FragmentTarikBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tabungViewModel =
            ViewModelProvider(this).get(TarikViewModel::class.java)
        _binding = FragmentTarikBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}