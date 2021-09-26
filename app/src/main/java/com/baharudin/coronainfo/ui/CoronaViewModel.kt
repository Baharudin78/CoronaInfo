package com.baharudin.coronainfo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.coronainfo.api.CoronaRepository
import com.baharudin.coronainfo.model.indonesia.CoronaIndonesiaResponse
import com.baharudin.coronainfo.model.world.WorldDataResponse
import com.baharudin.coronainfo.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class CoronaViewModel(
    val repository: CoronaRepository
) : ViewModel() {

    val getIndonesiaCase : MutableLiveData <Resource<CoronaIndonesiaResponse>> = MutableLiveData()
    val getPositifCase : MutableLiveData <Resource<WorldDataResponse>> = MutableLiveData()
    val getSembuhCase : MutableLiveData <Resource<WorldDataResponse>> = MutableLiveData()
    val getMeninggalCase : MutableLiveData <Resource<WorldDataResponse>> = MutableLiveData()

    init {
        getIndonesiaCase()
        getPositifCase()
        getSembuhCase()
        getMeninggalCase()
    }

    fun getIndonesiaCase() = viewModelScope.launch {
        getIndonesiaCase.postValue(Resource.Loading())
        val response = repository.getIndonesiaCase()
        getIndonesiaCase.postValue(handleResponse(response))
    }
    fun getPositifCase() = viewModelScope.launch {
        getIndonesiaCase.postValue(Resource.Loading())
        val response = repository.getPositifCase()
        getPositifCase.postValue(handleResponsePositif(response))
    }
    fun getSembuhCase() = viewModelScope.launch {
        getSembuhCase.postValue(Resource.Loading())
        val sembuhResponse = repository.getSembuhCase()
        getSembuhCase.postValue(handleResponseSembuh(sembuhResponse))
    }
    fun getMeninggalCase() = viewModelScope.launch {
        getMeninggalCase.postValue(Resource.Loading())
        val response = repository.getMeninggalCase()
        getMeninggalCase.postValue(handleMeninggalCase(response))
    }

    private fun handleMeninggalCase(response: Response<WorldDataResponse>): Resource<WorldDataResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleResponseSembuh(sembuhResponse: Response<WorldDataResponse>): Resource<WorldDataResponse>? {
        if (sembuhResponse.isSuccessful) {
            sembuhResponse.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(sembuhResponse.message())
    }

    private fun handleResponsePositif(response: Response<WorldDataResponse>): Resource<WorldDataResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())

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