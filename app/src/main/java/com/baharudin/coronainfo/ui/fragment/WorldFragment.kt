package com.baharudin.coronainfo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.coronainfo.R
import com.baharudin.coronainfo.databinding.FragmentWorldBinding
import com.baharudin.coronainfo.ui.CoronaViewModel
import com.baharudin.coronainfo.ui.MainActivity
import com.baharudin.coronainfo.util.Resource

class WorldFragment : Fragment(R.layout.fragment_world) {

    private var _binding : FragmentWorldBinding? = null
    private val binding get() = _binding!!
    private lateinit var coronaViewModel : CoronaViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentWorldBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        coronaViewModel = (activity as MainActivity).coronaViewModel


        getResultPositif()
        getSembuhCase()
        getMeninggalCase()

    }
    private fun getResultPositif() {
        coronaViewModel.getPositifCase.observe(viewLifecycleOwner, {response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let { result ->
                        hideProgress()
                        binding.tvPositif.text = result.value
                    }
                }
                is Resource.Error -> {
                    response.messege?.let { message ->
                        hideProgress()
                        Log.e("covid", message)
                    }
                }
                is Resource.Loading -> {
                    showProgress()
                }
            }
        })
    }
    private fun getSembuhCase() {
        coronaViewModel.getSembuhCase.observe(viewLifecycleOwner, {response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let { result ->
                        hideProgress()
                        binding.tvSembuh.text = result.value
                    }
                }
                is Resource.Error -> {
                    response.messege?.let {
                        hideProgress()
                        Log.e("ErrorSembuh", response.messege)
                    }
                }
                is Resource.Loading -> {
                    showProgress()
                }
            }
        })
    }

    private fun getMeninggalCase() {
        coronaViewModel.getMeninggalCase.observe(viewLifecycleOwner, {response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let { result ->
                        hideProgress()
                        binding.tvMeninggal.text = result.value
                    }
                }
                is Resource.Error -> {
                    response.messege?.let {
                        hideProgress()
                        Log.e("meninggal",response.messege)
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

}