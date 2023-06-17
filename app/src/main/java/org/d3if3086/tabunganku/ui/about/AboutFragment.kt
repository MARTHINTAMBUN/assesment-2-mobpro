package org.d3if3086.tabunganku.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import org.d3if3086.tabunganku.databinding.FragmentAboutBinding
import org.d3if3086.tabunganku.network.ApiStatus


class AboutFragment: Fragment()  {
    private lateinit var binding: FragmentAboutBinding
    private val viewModel: AboutViewModel by lazy {
        ViewModelProvider(this)[AboutViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(layoutInflater,
            container, false)
        val imageView = binding.imageView

        viewModel.urlGambar.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it).into(imageView)
        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.copyright.observe(viewLifecycleOwner, Observer {
            // updating data in displayMsg
            binding.text1.text = it
        })

        viewModel.status.observe(viewLifecycleOwner, {
            updateProgress(it)
        })

        binding.button4.setOnClickListener { urlGambar() }

    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.text1.visibility = View.GONE
                binding.imageView.visibility = View.GONE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
                binding.text1.visibility = View.VISIBLE
                binding.imageView.visibility = View.VISIBLE
                binding.networkError.visibility = View.GONE
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    private fun urlGambar() {
        viewModel.updateGambar(
            binding.editTextTextPersonName.text.toString()
        )
    }

}