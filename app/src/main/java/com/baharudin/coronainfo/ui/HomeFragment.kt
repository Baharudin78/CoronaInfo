package com.baharudin.coronainfo.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.startup.AppInitializer
import com.baharudin.coronainfo.R
import com.baharudin.coronainfo.databinding.FragmentHomeBinding
import net.danlew.android.joda.JodaTimeInitializer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var coronaViewModel : CoronaViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        coronaViewModel = (activity as MainActivity).coronaViewModel

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val formatted = current.format(formatter)
        binding.tvTanggal.text = formatted

    }
    fun getResponseResult() {
        coronaViewModel.getIndonesiaCase.observe(viewLifecycleOwner, {response ->
            when(response){

            }
        })
    }
}