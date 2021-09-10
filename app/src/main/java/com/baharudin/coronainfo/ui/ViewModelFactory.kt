package com.baharudin.coronainfo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baharudin.coronainfo.api.CoronaRepository

class ViewModelFactory(
    private val repository: CoronaRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoronaViewModel(repository) as T
    }
}