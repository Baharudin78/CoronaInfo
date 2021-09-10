package com.baharudin.coronainfo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.coronainfo.api.CoronaRepository
import com.baharudin.coronainfo.model.CoronaIndonesiaResponse
import com.baharudin.coronainfo.model.CoronaIndonesiaResponseItem
import com.baharudin.coronainfo.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class CoronaViewModel(
    val repository: CoronaRepository
) : ViewModel() {


    val getIndonesiaCase : MutableLiveData <Resource<CoronaIndonesiaResponse>> = MutableLiveData()

    init {
        getIndonesiaCase()
    }

    fun getIndonesiaCase() = viewModelScope.launch {
        getIndonesiaCase.postValue(Resource.Loading())
        val response = repository.getIndonesiaCase()
        getIndonesiaCase.postValue(handleResponse(response))
    }
    private fun handleResponse(response : Response<CoronaIndonesiaResponse>) :Resource<CoronaIndonesiaResponse> {
        if (response.isSuccessful) {
            response.body()?.let {result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

}