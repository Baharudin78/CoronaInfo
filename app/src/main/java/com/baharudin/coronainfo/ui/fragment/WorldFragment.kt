package com.baharudin.coronainfo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.coronainfo.R
import com.baharudin.coronainfo.databinding.FragmentWorldBinding

class WorldFragment : Fragment(R.layout.fragment_world) {

    private var _binding : FragmentWorldBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentWorldBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }
}