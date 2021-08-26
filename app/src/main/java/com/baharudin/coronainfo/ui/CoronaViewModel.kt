package com.baharudin.coronainfo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.coronainfo.api.CoronaRepository
import com.baharudin.coronainfo.model.IndonesiaKasusResponse
import com.baharudin.coronainfo.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class CoronaViewModel(
    val repository: CoronaRepository
) : ViewModel() {

    val getIndonesiaCase : MutableLiveData<Resource<IndonesiaKasusResponse>> = MutableLiveData()

    init {
        getIndonesiaCase()
    }

    fun getIndonesiaCase() = viewModelScope.launch {
        getIndonesiaCase.postValue(Resource.Loading())
        val response = repository.getIndonesiaCase()
        getIndonesiaCase.postValue(handleIndonesiaCase(response))
    }
    fun handleIndonesiaCase(response : Response<IndonesiaKasusResponse>) : Resource<IndonesiaKasusResponse> {
        if (response.isSuccessful) {
            response.body()?.let {result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}