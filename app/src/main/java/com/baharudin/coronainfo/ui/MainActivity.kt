package com.baharudin.coronainfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.baharudin.coronainfo.R
import com.baharudin.coronainfo.api.CoronaRepository
import com.baharudin.coronainfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var coronaViewModel: CoronaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coronaRepository = CoronaRepository()
        val coronaViewModelFactory = ViewModelFactory(coronaRepository)
        coronaViewModel = ViewModelProvider(this,coronaViewModelFactory).get(CoronaViewModel::class.java)

        val navigation = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navigation.navController
    }
}