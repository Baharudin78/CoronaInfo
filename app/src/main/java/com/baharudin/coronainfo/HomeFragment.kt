package com.baharudin.coronainfo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.startup.AppInitializer
import net.danlew.android.joda.JodaTimeInitializer

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppInitializer.getInstance(requireContext()).initializeComponent(JodaTimeInitializer::class.java)

    }
}