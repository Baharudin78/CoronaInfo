package com.baharudin.coronainfo.ui.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.coronainfo.R
import com.baharudin.coronainfo.adapter.CoronaAdapter
import com.baharudin.coronainfo.databinding.FragmentHomeBinding
import com.baharudin.coronainfo.model.indonesia.CoronaIndonesiaResponse
import com.baharudin.coronainfo.ui.CoronaViewModel
import com.baharudin.coronainfo.ui.MainActivity
import com.baharudin.coronainfo.util.Resource
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var coronaViewModel : CoronaViewModel
    private var dataList = ArrayList<CoronaIndonesiaResponse>()
    private lateinit var coronaAdapter: CoronaAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        coronaAdapter = CoronaAdapter()

        coronaViewModel = (activity as MainActivity).coronaViewModel

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val formatted = current.format(formatter)
        binding.tvTanggal.text = formatted

        binding.mcWorld.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_worldFragment)
        }
        binding.mcProvince.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_provinceFragment)
        }

        getDataIndonesia()
    }
    private fun getDataIndonesia() {
        coronaViewModel.getIndonesiaCase.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Success -> {
                    hideProgress()
                    it.data?.let { result ->
                        setRecycleview()
                        dataList.add(result)
                        coronaAdapter.differ.submitList(result)
                    }
                }
                is Resource.Error -> {
                    hideProgress()
                    it.messege?.let { messege ->
                        Log.e("error", "di $messege")
                    }
                }
                is Resource.Loading -> {
                    showProgress()
                }
            }
        })
    }

    private fun showProgress() {
        binding.progressBar2.visibility = View.VISIBLE
    }
    private fun hideProgress() {
        binding.progressBar2.visibility = View.GONE
    }
    private fun setRecycleview() {
        binding.apply {
            recycleview.adapter = coronaAdapter
            recycleview.layoutManager = LinearLayoutManager(requireContext())
            recycleview.setHasFixedSize(true)

        }
    }

}

