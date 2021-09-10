package com.baharudin.coronainfo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.coronainfo.R
import com.baharudin.coronainfo.databinding.FragmentProvinceBinding

class ProvinceFragment: Fragment(R.layout.fragment_province) {

    private var _binding : FragmentProvinceBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentProvinceBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }
}